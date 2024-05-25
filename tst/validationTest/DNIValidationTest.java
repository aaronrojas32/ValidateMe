package validationTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exception.ValidationException;
import validation.DNIValidation;

public class DNIValidationTest {

	@Test
	public void testValidDNI() {
		try {
			assertTrue(DNIValidation.isValidDNI("12345678Z"), "DNI 12345678Z should be valid");
		} catch (ValidationException e) {
			fail("ValidationException should not be thrown for valid DNI 12345678Z");
		}
	}

	@Test
	public void testValidDNISpaces() {
		try {
			assertTrue(DNIValidation.isValidDNI(" 12345678Z "),
					"DNI 12345678Z should be valid even with leading and trailing spaces");
		} catch (ValidationException e) {
			fail("ValidationException should not be thrown for valid DNI 12345678Z with spaces");
		}
	}

	@Test
	public void testLowerCaseDNILetter() {
		try {
			assertTrue(DNIValidation.isValidDNI("12345678z"), "DNI 12345678z should be valid with a lowercase letter");
		} catch (ValidationException e) {
			fail("ValidationException should not be thrown for valid DNI 12345678z with lowercase letter");
		}
	}

	@Test
	public void testInvalidDNIFormat() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("1234A5678Z");
		});
		assertEquals("Invalid DNI format", exception.getMessage(),
				"Invalid format 1234A5678Z should throw ValidationException with message 'Invalid DNI format'");
	}

	@Test
	public void testInvalidDNILetter() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("12345678A");
		});
		assertEquals("Invalid DNI letter", exception.getMessage(),
				"Invalid letter 12345678A should throw ValidationException with message 'Invalid DNI letter'");
	}

	@Test
	public void testInvalidDNINonNumeric() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("1234567aZ");
		});
		assertEquals("Invalid DNI format", exception.getMessage(),
				"Non-numeric characters in 1234567aZ should throw ValidationException with message 'Invalid DNI format'");
	}

	@Test
	public void testEmptyDNI() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("");
		});
		assertEquals("Invalid DNI format", exception.getMessage(),
				"Empty DNI should throw ValidationException with message 'Invalid DNI format'");
	}

	@Test
	public void testShortDNI() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("1234567Z");
		});
		assertEquals("Invalid DNI format", exception.getMessage(),
				"DNI with less than 8 digits 1234567Z should throw ValidationException with message 'Invalid DNI format'");
	}

	@Test
	public void testLongDNI() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("123456789Z");
		});
		assertEquals("Invalid DNI format", exception.getMessage(),
				"DNI with more than 8 digits 123456789Z should throw ValidationException with message 'Invalid DNI format'");
	}

	@Test
	public void testInvalidCharacters() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("1234567*Z");
		});
		assertEquals("Invalid DNI format", exception.getMessage(),
				"DNI with invalid characters 1234567*Z should throw ValidationException with message 'Invalid DNI format'");
	}

	@Test
	public void testValidDNINumbersWithDifferentLetters() {
		try {
			assertTrue(DNIValidation.isValidDNI("00000000T"), "DNI 00000000T with valid letter T should be valid");
			assertTrue(DNIValidation.isValidDNI("00000001R"), "DNI 00000001R with valid letter R should be valid");
			assertTrue(DNIValidation.isValidDNI("00000002W"), "DNI 00000002W with valid letter W should be valid");
			assertTrue(DNIValidation.isValidDNI("00000003A"), "DNI 00000003A with valid letter A should be valid");
			// Add more test cases as needed for different numbers and corresponding valid
			// letters
		} catch (ValidationException e) {
			fail("ValidationException should not be thrown for valid DNIs with different letters");
		}
	}

	@Test
	public void testEdgeCases() {
		try {
			assertTrue(DNIValidation.isValidDNI("00000000T"), "Edge case DNI 00000000T should be valid");
			assertTrue(DNIValidation.isValidDNI("99999999R"), "Edge case DNI 99999999R should be valid");
		} catch (ValidationException e) {
			fail("ValidationException should not be thrown for edge case DNIs");
		}
	}

	@Test
	public void testInvalidLettersNearValidOnes() {
		assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("00000000U");
		}, "DNI with invalid letter near valid T (00000000U) should throw ValidationException");

		assertThrows(ValidationException.class, () -> {
			DNIValidation.isValidDNI("99999999S");
		}, "DNI with invalid letter near valid R (99999999S) should throw ValidationException");
	}
}
