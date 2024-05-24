package lengthTest;

import exception.LengthException;
import org.junit.jupiter.api.Test;
import validation.LengthValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LengthValidationTest {

    @Test
    public void testValidateStringWithSpaces() {
        LengthValidation validator = new LengthValidation();
        String validString = "Hello, World!";
        String invalidString = "This is a very long string";

        assertDoesNotThrow(() -> validator.validateStringWithSpaces(validString, 20), "Valid string with spaces should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateStringWithSpaces(invalidString, 10), "Invalid string with spaces should throw LengthException");
    }

    @Test
    public void testValidateStringWithoutSpaces() {
        LengthValidation validator = new LengthValidation();
        String validString = "HelloWorld";
        String invalidString = "This is a very long string";

        assertDoesNotThrow(() -> validator.validateStringWithoutSpaces(validString, 10), "Valid string without spaces should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateStringWithoutSpaces(invalidString, 5), "Invalid string without spaces should throw LengthException");
    }

    @Test
    public void testValidateArrayLength() {
        LengthValidation validator = new LengthValidation();
        Integer[] validArray = {1, 2, 3};
        Integer[] invalidArray = {1, 2, 3, 4, 5};

        assertDoesNotThrow(() -> validator.validateArrayLength(validArray, 5), "Valid array length should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateArrayLength(invalidArray, 2), "Invalid array length should throw LengthException");
    }

    @Test
    public void testValidateListLength() {
        LengthValidation validator = new LengthValidation();
        List<String> validList = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
        List<String> invalidList = new ArrayList<>(Arrays.asList("apple", "banana", "orange", "kiwi"));

        assertDoesNotThrow(() -> validator.validateListLength(validList, 4), "Valid list length should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateListLength(invalidList, 2), "Invalid list length should throw LengthException");
    }

    @Test
    public void testValidateMinimumLength() {
        LengthValidation validator = new LengthValidation();
        String validString = "Hello";
        String invalidString = "Hi";

        assertDoesNotThrow(() -> validator.validateMinimumLength(validString, 5), "String meeting minimum length requirement should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateMinimumLength(invalidString, 5), "String not meeting minimum length requirement should throw LengthException");
    }

    @Test
    public void testValidateStringLengthInRange() {
        LengthValidation validator = new LengthValidation();
        String validString = "Hello";
        String invalidString = "Hi";

        assertDoesNotThrow(() -> validator.validateStringLengthInRange(validString, 3, 6), "String within range should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateStringLengthInRange(invalidString, 3, 4), "String outside range should throw LengthException");
    }

    @Test
    public void testValidateArrayLengthInRange() {
        LengthValidation validator = new LengthValidation();
        Integer[] validArray = {1, 2, 3};
        Integer[] invalidArray = {1, 2, 3, 4, 5};

        assertDoesNotThrow(() -> validator.validateArrayLengthInRange(validArray, 2, 5), "Array within range should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateArrayLengthInRange(invalidArray, 2, 3), "Array outside range should throw LengthException");
    }

    @Test
    public void testValidateListSizeInRange() {
        LengthValidation validator = new LengthValidation();
        List<String> validList = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
        List<String> invalidList = new ArrayList<>(Arrays.asList("apple", "banana", "orange", "kiwi"));

        assertDoesNotThrow(() -> validator.validateListSizeInRange(validList, 2, 4), "List within range should not throw exception");
        assertThrows(LengthException.class, () -> validator.validateListSizeInRange(invalidList, 2, 3), "List outside range should throw LengthException");
    }
}
