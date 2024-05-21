package hourTest;

import static org.junit.Assert.*;
import org.junit.Test;
import validation.HourValidation;
import exception.HourException;

public class HourValidationTest {

	private HourValidation validator = new HourValidation();

	@Test
	public void testIntHourValidation() {
		try {
			assertTrue(validator.IntHourValidation(14, 30)); // Valid 24-hour time
			assertTrue(validator.IntHourValidation(0, 0)); // Valid 24-hour time at midnight
			assertTrue(validator.IntHourValidation(23, 59)); // Valid 24-hour time just before midnight

			validator.IntHourValidation(-1, 30); // Invalid hour
			fail("Expected HourException for hour: -1, minute: 30");
		} catch (HourException e) {
			assertEquals("The hour -1:30 is wrong", e.getMessage());
		}

		try {
			validator.IntHourValidation(25, 30); // Invalid hour
			fail("Expected HourException for hour: 25, minute: 30");
		} catch (HourException e) {
			assertEquals("The hour 25:30 is wrong", e.getMessage());
		}

		try {
			validator.IntHourValidation(14, -5); // Invalid minute
			fail("Expected HourException for hour: 14, minute: -5");
		} catch (HourException e) {
			assertEquals("The hour 14:-5 is wrong", e.getMessage());
		}

		try {
			validator.IntHourValidation(14, 60); // Invalid minute
			fail("Expected HourException for hour: 14, minute: 60");
		} catch (HourException e) {
			assertEquals("The hour 14:60 is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValid12HourFormat() {
		try {
			assertTrue(validator.isValid12HourFormat(12, 30, true)); // Valid 12-hour time PM
			assertTrue(validator.isValid12HourFormat(1, 0, false)); // Valid 12-hour time AM
			assertTrue(validator.isValid12HourFormat(11, 59, true)); // Valid 12-hour time just before noon

			validator.isValid12HourFormat(0, 30, true); // Invalid hour
			fail("Expected HourException for hour: 0, minute: 30 PM");
		} catch (HourException e) {
			assertEquals("The hour 0:30 PM is wrong", e.getMessage());
		}

		try {
			validator.isValid12HourFormat(13, 30, true); // Invalid hour
			fail("Expected HourException for hour: 13, minute: 30 PM");
		} catch (HourException e) {
			assertEquals("The hour 13:30 PM is wrong", e.getMessage());
		}

		try {
			validator.isValid12HourFormat(10, -5, false); // Invalid minute
			fail("Expected HourException for hour: 10, minute: -5 AM");
		} catch (HourException e) {
			assertEquals("The hour 10:-5 AM is wrong", e.getMessage());
		}

		try {
			validator.isValid12HourFormat(10, 60, true); // Invalid minute
			fail("Expected HourException for hour: 10, minute: 60 PM");
		} catch (HourException e) {
			assertEquals("The hour 10:60 PM is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString() {
		try {
			assertTrue(validator.isValidTimeString("12:30 PM")); // Valid time string
			assertTrue(validator.isValidTimeString("01:00 AM")); // Valid time string
			assertTrue(validator.isValidTimeString("11:59 pm")); // Valid time string with lowercase PM

			validator.isValidTimeString("13:00 PM"); // Invalid hour
			fail("Expected HourException for time string: 13:00 PM");
		} catch (HourException e) {
			assertEquals("The time string 13:00 PM is in the wrong format", e.getMessage());
		}

		try {
			validator.isValidTimeString("10:60 AM"); // Invalid minute
			fail("Expected HourException for time string: 10:60 AM");
		} catch (HourException e) {
			assertEquals("The time string 10:60 AM is in the wrong format", e.getMessage());
		}

		try {
			validator.isValidTimeString("10:30"); // Missing AM/PM
			fail("Expected HourException for time string: 10:30");
		} catch (HourException e) {
			assertEquals("The time string 10:30 is in the wrong format", e.getMessage());
		}

		try {
			validator.isValidTimeString("25:00 PM"); // Invalid hour
			fail("Expected HourException for time string: 25:00 PM");
		} catch (HourException e) {
			assertEquals("The time string 25:00 PM is in the wrong format", e.getMessage());
		}
	}
}