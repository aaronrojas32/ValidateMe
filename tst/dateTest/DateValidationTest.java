package dateTest;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exception.DateException;
import validation.DateValidation;

public class DateValidationTest {

	private DateValidation validator;

	@Before
	public void setUp() {
		validator = new DateValidation();
	}

	@After
	public void tearDown() {
		validator = null;
	}

	@Test
	public void testDayValidation() {
		try {
			// Valid test cases
			assertTrue("Expected dayValidation(1) to return true", validator.dayValidation(1)); // Minimum allowed day
			assertTrue("Expected dayValidation(15) to return true", validator.dayValidation(15)); // Day within allowed
																									// range
			assertTrue("Expected dayValidation(31) to return true", validator.dayValidation(31)); // Maximum allowed day

			// Invalid test cases
			assertInvalidDay(-1); // Negative day
			assertInvalidDay(0); // Day zero
			assertInvalidDay(32); // Day greater than maximum allowed
		} catch (DateException e) {
			fail("Unexpected DateException: " + e.getMessage());
		}
	}

	@Test
	public void testMonthValidation() {
		try {
			// Valid test cases
			assertTrue("Expected monthValidation(1) to return true", validator.monthValidation(1)); // Minimum allowed
																									// month
			assertTrue("Expected monthValidation(6) to return true", validator.monthValidation(6)); // Month within
																									// allowed range
			assertTrue("Expected monthValidation(12) to return true", validator.monthValidation(12)); // Maximum allowed
																										// month
		} catch (DateException e) {
			fail("Unexpected DateException: " + e.getMessage());
		}

		// Invalid test cases
		assertInvalidMonth(-1); // Negative month
		assertInvalidMonth(0); // Month zero
		assertInvalidMonth(13); // Month greater than maximum allowed
	}

	@Test
	public void testYearValidation() {
		try {
			// Valid test cases
			assertTrue("Expected yearValidation(0) to return true", validator.yearValidation(0)); // Minimum allowed
																									// year
			assertTrue("Expected yearValidation(1990) to return true", validator.yearValidation(1990)); // Year within
																										// allowed range
			assertTrue("Expected yearValidation(2024) to return true", validator.yearValidation(2024)); // Current year
																										// (may vary)
		} catch (DateException e) {
			fail("Unexpected DateException: " + e.getMessage());
		}

		// Invalid test cases
		assertInvalidYear(-1); // Negative year
	}

	@Test
	public void testDayAndMonthValidation() {
		try {
			// Valid test cases
			assertTrue("Expected dayAndMonthValidation(1, 1) to return true", validator.dayAndMonthValidation(1, 1)); // Minimum
																														// allowed
																														// day
																														// and
																														// month
			assertTrue("Expected dayAndMonthValidation(15, 6) to return true", validator.dayAndMonthValidation(15, 6)); // Day
																														// and
																														// month
																														// within
																														// allowed
																														// range
			assertTrue("Expected dayAndMonthValidation(31, 12) to return true",
					validator.dayAndMonthValidation(31, 12)); // Maximum allowed day and month
		} catch (DateException e) {
			fail("Unexpected DateException: " + e.getMessage());
		}

		// Invalid test cases
		assertInvalidDayAndMonth(0, 0); // Day and month zero
		assertInvalidDayAndMonth(-1, 5); // Negative day
		assertInvalidDayAndMonth(32, 4); // Day greater than maximum allowed for April
		assertInvalidDayAndMonth(15, 13); // Month greater than maximum allowed
	}

	@Test
	public void testDayMonthYearValidation() {
		try {
			// Valid test cases
			assertTrue("Expected dayMonthYearValidation(1, 1, 2024) to return true",
					validator.dayMonthYearValidation(1, 1, 2024)); // Minimum allowed date
			assertTrue("Expected dayMonthYearValidation(15, 6, 2020) to return true",
					validator.dayMonthYearValidation(15, 6, 2020)); // Date within allowed range
			assertTrue("Expected dayMonthYearValidation(31, 12, 2024) to return true",
					validator.dayMonthYearValidation(31, 12, 2024)); // Maximum allowed date
		} catch (DateException e) {
			fail("Unexpected DateException: " + e.getMessage());
		}

		// Invalid test cases
		assertInvalidDate(0, 0, 0); // Date with day, month, and year zero
		assertInvalidDate(-1, 5, 2024); // Negative day
		assertInvalidDate(32, 4, 2021); // Day greater than maximum allowed for April
		assertInvalidDate(15, 13, 2022); // Month greater than maximum allowed
		assertInvalidDate(29, 2, 2021); // Non-leap year, day greater than maximum allowed for February
		assertInvalidDate(30, 2, 2020); // Leap year, day greater than maximum allowed for February
	}

	@Test
	public void testValidateDateString() {
		// Valid test cases
		assertTrue("Expected validateDateString(\"01/01/2024\") to return true",
				validator.validateDateString("01/01/2024")); // Valid date
		assertTrue("Expected validateDateString(\"15/06/2020\") to return true",
				validator.validateDateString("15/06/2020")); // Valid date
		assertTrue("Expected validateDateString(\"31/12/2024\") to return true",
				validator.validateDateString("31/12/2024")); // Valid date

		// Invalid test cases
		assertFalse("Expected validateDateString(\"00/00/0000\") to return false",
				validator.validateDateString("00/00/0000")); // Date with day, month, and year zero
		assertFalse("Expected validateDateString(\"32/04/2021\") to return false",
				validator.validateDateString("32/04/2021")); // Day greater than maximum allowed for April
		assertFalse("Expected validateDateString(\"15/13/2022\") to return false",
				validator.validateDateString("15/13/2022")); // Month greater than maximum allowed
		assertFalse("Expected validateDateString(\"29/02/2021\") to return false",
				validator.validateDateString("29/02/2021")); // Non-leap year, day greater than maximum allowed for
																// February
		assertFalse("Expected validateDateString(\"30/02/2020\") to return false",
				validator.validateDateString("30/02/2020")); // Leap year, day greater than maximum allowed for February
		assertFalse("Expected validateDateString(\"2021-02-29\") to return false",
				validator.validateDateString("2021-02-29")); // Incorrect date format
		assertFalse("Expected validateDateString(\"2020/02/30\") to return false",
				validator.validateDateString("2020/02/30")); // Incorrect date format
	}

	private void assertInvalidDay(int day) {
		try {
			validator.dayValidation(day);
			fail("Expected DateException to be thrown for day: " + day);
		} catch (DateException e) {
			// Expected exception
		}
	}

	private void assertInvalidMonth(int month) {
		try {
			validator.monthValidation(month);
			fail("Expected DateException to be thrown for month: " + month);
		} catch (DateException e) {
			// Expected exception
		}
	}

	private void assertInvalidYear(int year) {
		try {
			validator.yearValidation(year);
			fail("Expected DateException to be thrown for year: " + year);
		} catch (DateException e) {
			// Expected exception
		}
	}

	private void assertInvalidDayAndMonth(int day, int month) {
		try {
			validator.dayAndMonthValidation(day, month);
			fail("Expected DateException to be thrown for day: " + day + ", month: " + month);
		} catch (DateException e) {
			// Expected exception
		}
	}

	private void assertInvalidDate(int day, int month, int year) {
		try {
			validator.dayMonthYearValidation(day, month, year);
			fail("Expected DateException to be thrown for date: " + day + "/" + month + "/" + year);
		} catch (DateException e) {
			// Expected exception
		}
	}

}
