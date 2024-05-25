package validationTest;

import org.junit.jupiter.api.Test;

import validation.PhoneValidation;
import exception.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidationTest {

	@Test
	public void testValidPhoneNumber() {
		String[] validPhoneNumbers = { "+1234567890", // USA
				"+447123456789", // UK
				"+33123456789", // France
				"+8134567890", // Japan
				"+861234567890", // China
				"+79123456789" // Russia
		};
		for (String phoneNumber : validPhoneNumbers) {
			assertDoesNotThrow(() -> {
				PhoneValidation.validatePhoneNumber(phoneNumber);
			}, "Unexpected ValidationException for valid phone number: " + phoneNumber);
		}
	}

	@Test
	public void testInvalidPhoneNumber() {
		String[] invalidPhoneNumbers = { "+34567890", // Too short
				"+12345678901234567890", // Too long
				"+abcd1234567890", // Contains non-numeric characters
				"+01234567890" // Invalid country code
		};
		for (String phoneNumber : invalidPhoneNumbers) {
			assertThrows(ValidationException.class, () -> {
				PhoneValidation.validatePhoneNumber(phoneNumber);
			}, "Expected invalid phone number: " + phoneNumber);
		}
	}

	@Test
	public void testNullPhoneNumber() {
		String nullPhoneNumber = null;
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			PhoneValidation.validatePhoneNumber(nullPhoneNumber);
		});
		assertEquals("Phone number is null", exception.getMessage(),
				"Expected exception message for null phone number");
	}

	@Test
	public void testEmptyPhoneNumber() {
		String emptyPhoneNumber = "";
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			PhoneValidation.validatePhoneNumber(emptyPhoneNumber);
		});
		assertEquals("Phone number is empty", exception.getMessage(),
				"Expected exception message for empty phone number");
	}

	@Test
	public void testRandomAlphanumeric() {
		String randomAlphanumeric = "random123";
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			PhoneValidation.validatePhoneNumber(randomAlphanumeric);
		});
		assertEquals("Invalid phone number: random123", exception.getMessage(),
				"Expected exception message for random alphanumeric string");
	}

	@Test
	public void testInvalidCountryCode() {
		String invalidCountryCode = "+999123456789"; // Invalid country code
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			PhoneValidation.validatePhoneNumber(invalidCountryCode);
		});
		assertEquals("Invalid phone number: " + invalidCountryCode, exception.getMessage(),
				"Expected exception message for invalid country code");
	}

	@Test
	public void testTooLongPhoneNumber() {
		String tooLongPhoneNumber = "+123456789012345678901"; // Too long
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			PhoneValidation.validatePhoneNumber(tooLongPhoneNumber);
		});
		assertEquals("Invalid phone number: " + tooLongPhoneNumber, exception.getMessage(),
				"Expected exception message for too long phone number");
	}

	@Test
	public void testTooShortPhoneNumber() {
		String tooShortPhoneNumber = "+123"; // Too short
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			PhoneValidation.validatePhoneNumber(tooShortPhoneNumber);
		});
		assertEquals("Invalid phone number: " + tooShortPhoneNumber, exception.getMessage(),
				"Expected exception message for too short phone number");
	}
}