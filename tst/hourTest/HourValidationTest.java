package hourTest;

import static org.junit.Assert.*;
import org.junit.Test;

import validation.HourValidation;
import exception.HourException;

public class HourValidationTest {

	@Test
	public void testIntHourValidation_ValidTime() {
		HourValidation validation = new HourValidation();
		try {
			boolean result = validation.IntHourValidation(12, 30);
			assertTrue(result);
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testIntHourValidation_InvalidHour() {
		HourValidation validation = new HourValidation();
		try {
			validation.IntHourValidation(25, 30);
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The hour 25:30 is wrong", e.getMessage());
		}
	}

	@Test
	public void testIntHourValidation_InvalidMinute() {
		HourValidation validation = new HourValidation();
		try {
			validation.IntHourValidation(12, 60);
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The hour 12:60 is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValid12HourFormat_ValidTime() {
		HourValidation validation = new HourValidation();
		try {
			boolean result = validation.isValid12HourFormat(12, 30, true);
			assertTrue(result);
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testIsValid12HourFormat_InvalidHour() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValid12HourFormat(13, 30, true);
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The hour 13:30 PM is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValid12HourFormat_InvalidMinute() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValid12HourFormat(12, 60, true);
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The hour 12:60 PM is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString12Hours_ValidTime() {
		HourValidation validation = new HourValidation();
		try {
			boolean result = validation.isValidTimeString12Hours("12:30 PM");
			assertTrue(result);
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString12Hours_InvalidFormat() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValidTimeString12Hours("25:30 PM");
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The time 25:30 PM is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString12Hours_InvalidHour() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValidTimeString12Hours("13:30 PM");
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The time 13:30 PM is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString12Hours_InvalidMinute() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValidTimeString12Hours("12:60 PM");
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The time 12:60 PM is wrong", e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString_ValidTime() {
		HourValidation validation = new HourValidation();
		try {
			boolean result = validation.isValidTimeString("12:30");
			assertTrue(result);
		} catch (HourException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString_InvalidFormat() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValidTimeString("25:30");
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The time string 25:30 is in the wrong format", e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString_InvalidHour() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValidTimeString("24:30");
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The time string 24:30 is in the wrong format", e.getMessage());
		}
	}

	@Test
	public void testIsValidTimeString_InvalidMinute() {
		HourValidation validation = new HourValidation();
		try {
			validation.isValidTimeString("12:60");
			fail("Expected HourException not thrown");
		} catch (HourException e) {
			assertEquals("The time string 12:60 is in the wrong format", e.getMessage());
		}
	}
}