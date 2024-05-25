package validationTest;

import exception.ValidationException;
import validation.IPValidation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IPValidationTest {

	@Test
	public void testValidateIP_ValidIPv4() {
		IPValidation validator = new IPValidation();
		String validIP = "192.168.0.1";
		try {
			assertTrue(validator.validateIP(validIP));
		} catch (ValidationException e) {
			fail("Unexpected ValidationException: " + e.getMessage());
		}
	}

	@Test
	public void testValidateIP_InvalidIPv4_Null() {
		IPValidation validator = new IPValidation();
		String invalidIP = null;
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			validator.validateIP(invalidIP);
		});
		assertEquals("IP address is null", exception.getMessage());
	}

	@Test
	public void testValidateIP_InvalidIPv4_Format() {
		IPValidation validator = new IPValidation();
		String invalidIP = "192.168.0.256";
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			validator.validateIP(invalidIP);
		});
		assertEquals("IP address part out of range: 256", exception.getMessage());
	}

	@Test
	public void testValidateIP_InvalidIPv4_WrongPartsCount() {
		IPValidation validator = new IPValidation();
		String invalidIP = "192.168.0";
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			validator.validateIP(invalidIP);
		});
		assertEquals("IP address does not have four parts", exception.getMessage());
	}

	@Test
	public void testValidateIPAsNumber_Valid() {
		IPValidation validator = new IPValidation();
		long validIPAsNumber = 3232235521L; // This represents 192.168.0.1
		try {
			assertTrue(validator.validateIPAsNumber(validIPAsNumber));
		} catch (ValidationException e) {
			fail("Unexpected ValidationException: " + e.getMessage());
		}
	}

	@Test
	public void testValidateIPAsNumber_Invalid_OutOfRange() {
		IPValidation validator = new IPValidation();
		long invalidIPAsNumber = 4294967296L; // 2^32, out of range
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			validator.validateIPAsNumber(invalidIPAsNumber);
		});
		assertEquals("IP integer is out of valid range", exception.getMessage());
	}
}
