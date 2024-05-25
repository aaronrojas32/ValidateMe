package validationTest;

import exception.ValidationException;
import validation.IPValidator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IPValidationTest {

    @Test
    public void testValidateIP_ValidIPv4() {
        IPValidator validator = new IPValidator();
        String validIP = "192.168.0.1";
        try {
            assertTrue(validator.validateIP(validIP));
        } catch (ValidationException e) {
            fail("Unexpected ValidationException: " + e.getMessage());
        }
    }

    @Test
    public void testValidateIP_InvalidIPv4_Null() {
        IPValidator validator = new IPValidator();
        String invalidIP = null;
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            validator.validateIP(invalidIP);
        });
        assertEquals("IP address is null", exception.getMessage());
    }

    @Test
    public void testValidateIP_InvalidIPv4_Format() {
        IPValidator validator = new IPValidator();
        String invalidIP = "192.168.0.256";
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            validator.validateIP(invalidIP);
        });
        assertEquals("IP address part out of range: 256", exception.getMessage());
    }

    @Test
    public void testValidateIP_InvalidIPv4_WrongPartsCount() {
        IPValidator validator = new IPValidator();
        String invalidIP = "192.168.0";
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            validator.validateIP(invalidIP);
        });
        assertEquals("IP address does not have four parts", exception.getMessage());
    }

    @Test
    public void testValidateIPAsNumber_Valid() {
        IPValidator validator = new IPValidator();
        long validIPAsNumber = 3232235521L; // This represents 192.168.0.1
        try {
            assertTrue(validator.validateIPAsNumber(validIPAsNumber));
        } catch (ValidationException e) {
            fail("Unexpected ValidationException: " + e.getMessage());
        }
    }

    @Test
    public void testValidateIPAsNumber_Invalid_OutOfRange() {
        IPValidator validator = new IPValidator();
        long invalidIPAsNumber = 4294967296L; // 2^32, out of range
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            validator.validateIPAsNumber(invalidIPAsNumber);
        });
        assertEquals("IP integer is out of valid range", exception.getMessage());
    }
}
