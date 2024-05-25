package validationTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.StringValidation;
import exception.ValidationException;

public class StringValidationTest {

    private StringValidation validator;

    @BeforeEach
    public void setUp() {
        validator = new StringValidation();
    }

    @Test
    public void testIsNotEmpty() {
        assertDoesNotThrow(() -> validator.isNotEmpty("Test"));
        assertDoesNotThrow(() -> validator.isNotEmpty("    Test   "));
        
        assertThrows(ValidationException.class, () -> validator.isNotEmpty(""));
        assertThrows(ValidationException.class, () -> validator.isNotEmpty("    "));
        assertThrows(ValidationException.class, () -> validator.isNotEmpty(null));
    }

    @Test
    public void testHasValidLength() {
        assertDoesNotThrow(() -> validator.hasValidLength("Test", 1, 5));
        assertDoesNotThrow(() -> validator.hasValidLength("Hello, World!", 5, 20));
        
        assertThrows(ValidationException.class, () -> validator.hasValidLength("Test", 5, 10));
        assertThrows(ValidationException.class, () -> validator.hasValidLength("Test", 1, 3));
        assertThrows(ValidationException.class, () -> validator.hasValidLength("", 1, 3));
        assertThrows(ValidationException.class, () -> validator.hasValidLength(null, 1, 5));
    }

    @Test
    public void testIsNumeric() {
        assertDoesNotThrow(() -> validator.isNumeric("12345"));
        assertDoesNotThrow(() -> validator.isNumeric("0000"));
        
        assertThrows(ValidationException.class, () -> validator.isNumeric("12345a"));
        assertThrows(ValidationException.class, () -> validator.isNumeric("12 345"));
        assertThrows(ValidationException.class, () -> validator.isNumeric("123.45"));
        assertThrows(ValidationException.class, () -> validator.isNumeric(""));
        assertThrows(ValidationException.class, () -> validator.isNumeric(null));
    }

    @Test
    public void testIsAlphanumeric() {
        assertDoesNotThrow(() -> validator.isAlphanumeric("abc123"));
        assertDoesNotThrow(() -> validator.isAlphanumeric("ABC123"));
        assertDoesNotThrow(() -> validator.isAlphanumeric("a1b2c3"));
        
        assertThrows(ValidationException.class, () -> validator.isAlphanumeric("abc123!"));
        assertThrows(ValidationException.class, () -> validator.isAlphanumeric("abc 123"));
        assertThrows(ValidationException.class, () -> validator.isAlphanumeric("abc123_"));
        assertThrows(ValidationException.class, () -> validator.isAlphanumeric(""));
        assertThrows(ValidationException.class, () -> validator.isAlphanumeric(null));
    }
    
    @Test
    public void testComplexStrings() {
        assertDoesNotThrow(() -> validator.isNotEmpty("A quick brown fox jumps over the lazy dog."));
        assertDoesNotThrow(() -> validator.hasValidLength("A quick brown fox", 10, 30));
        
        assertThrows(ValidationException.class, () -> validator.isNumeric("123abc"));
        assertThrows(ValidationException.class, () -> validator.isAlphanumeric("abc@123"));
    }
}