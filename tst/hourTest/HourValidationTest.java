package hourTest;

import exception.HourException;
import validation.HourValidation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourValidationTest {

	@Test
	void testIntHourValidation_ValidTime_ReturnsTrue() {
		HourValidation validator = new HourValidation();
		try {
			assertTrue(validator.IntHourValidation(12, 30));
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	void testIntHourValidation_InvalidHour_ThrowsHourException() {
		HourValidation validator = new HourValidation();
		assertThrows(HourException.class, () -> validator.IntHourValidation(25, 30));
	}

	@Test
	void testIsValid12HourFormat_ValidTime_ReturnsTrue() {
		HourValidation validator = new HourValidation();
		try {
			assertTrue(validator.isValid12HourFormat(12, 30, true));
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	void testIsValid12HourFormat_InvalidMinute_ThrowsHourException() {
		HourValidation validator = new HourValidation();
		assertThrows(HourException.class, () -> validator.isValid12HourFormat(3, 60, false));
	}

	@Test
	void testIsValidTimeString12Hours_ValidTime_ReturnsTrue() {
		HourValidation validator = new HourValidation();
		try {
			assertTrue(validator.isValidTimeString12Hours("12:30 PM"));
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	void testIsValidTimeString12Hours_InvalidFormat_ThrowsHourException() {
		HourValidation validator = new HourValidation();
		assertThrows(HourException.class, () -> validator.isValidTimeString12Hours("13:30"));
	}

	@Test
	void testIsValidTimeString_ValidTime_ReturnsTrue() {
		HourValidation validator = new HourValidation();
		try {
			assertTrue(validator.isValidTimeString("12:30 PM"));
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	void testIsValidTimeString_InvalidTime_ThrowsHourException() {
		HourValidation validator = new HourValidation();
		assertThrows(HourException.class, () -> validator.isValidTimeString("25:30"));
	}
}
