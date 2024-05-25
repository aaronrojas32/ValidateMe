package stringTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.StringValidation;
import exception.StringException;

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
        
        assertThrows(StringException.class, () -> validator.isNotEmpty(""));
        assertThrows(StringException.class, () -> validator.isNotEmpty("    "));
        assertThrows(StringException.class, () -> validator.isNotEmpty(null));
    }

    @Test
    public void testHasValidLength() {
        assertDoesNotThrow(() -> validator.hasValidLength("Test", 1, 5));
        assertDoesNotThrow(() -> validator.hasValidLength("Hello, World!", 5, 20));
        
        assertThrows(StringException.class, () -> validator.hasValidLength("Test", 5, 10));
        assertThrows(StringException.class, () -> validator.hasValidLength("Test", 1, 3));
        assertThrows(StringException.class, () -> validator.hasValidLength("", 1, 3));
        assertThrows(StringException.class, () -> validator.hasValidLength(null, 1, 5));
    }

    @Test
    public void testIsNumeric() {
        assertDoesNotThrow(() -> validator.isNumeric("12345"));
        assertDoesNotThrow(() -> validator.isNumeric("0000"));
        
        assertThrows(StringException.class, () -> validator.isNumeric("12345a"));
        assertThrows(StringException.class, () -> validator.isNumeric("12 345"));
        assertThrows(StringException.class, () -> validator.isNumeric("123.45"));
        assertThrows(StringException.class, () -> validator.isNumeric(""));
        assertThrows(StringException.class, () -> validator.isNumeric(null));
    }

    @Test
    public void testIsAlphanumeric() {
        assertDoesNotThrow(() -> validator.isAlphanumeric("abc123"));
        assertDoesNotThrow(() -> validator.isAlphanumeric("ABC123"));
        assertDoesNotThrow(() -> validator.isAlphanumeric("a1b2c3"));
        
        assertThrows(StringException.class, () -> validator.isAlphanumeric("abc123!"));
        assertThrows(StringException.class, () -> validator.isAlphanumeric("abc 123"));
        assertThrows(StringException.class, () -> validator.isAlphanumeric("abc123_"));
        assertThrows(StringException.class, () -> validator.isAlphanumeric(""));
        assertThrows(StringException.class, () -> validator.isAlphanumeric(null));
    }
    
    @Test
    public void testComplexStrings() {
        assertDoesNotThrow(() -> validator.isNotEmpty("A quick brown fox jumps over the lazy dog."));
        assertDoesNotThrow(() -> validator.hasValidLength("A quick brown fox", 10, 30));
        
        assertThrows(StringException.class, () -> validator.isNumeric("123abc"));
        assertThrows(StringException.class, () -> validator.isAlphanumeric("abc@123"));
    }
}