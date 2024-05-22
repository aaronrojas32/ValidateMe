package dniTest;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.DNIException;
import validation.DNIValidation;

public class DNIValidationTest {

    @Test
    public void testValidDNI() {
        try {
            // Valid DNI: 12345678Z
            assertTrue("Valid DNI should pass validation", DNIValidation.isValidDNI("12345678Z"));
        } catch (DNIException e) {
            fail("Unexpected DNIException: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidFormat() {
        // Invalid format: less than 8 digits
        try {
            DNIValidation.isValidDNI("1234567Z");
            fail("Expected DNIException to be thrown for invalid format");
        } catch (DNIException e) {
            assertEquals("Invalid DNI format", e.getMessage());
        }

        // Invalid format: more than 8 digits
        try {
            DNIValidation.isValidDNI("123456789Z");
            fail("Expected DNIException to be thrown for invalid format");
        } catch (DNIException e) {
            assertEquals("Invalid DNI format", e.getMessage());
        }

        // Invalid format: non-digit characters
        try {
            DNIValidation.isValidDNI("12A34567Z");
            fail("Expected DNIException to be thrown for invalid format");
        } catch (DNIException e) {
            assertEquals("Invalid DNI format", e.getMessage());
        }
    }

    @Test
    public void testInvalidLetter() {
        try {
            // Invalid letter: 12345678X (expected letter is Z)
            assertFalse("DNI with invalid letter should fail validation", DNIValidation.isValidDNI("12345678X"));
        } catch (DNIException e) {
            fail("Unexpected DNIException: " + e.getMessage());
        }
    }

    @Test
    public void testValidWithLowerCaseLetter() {
        try {
            // Valid DNI with lowercase letter: 12345678z
            assertTrue("Valid DNI with lowercase letter should pass validation", DNIValidation.isValidDNI("12345678z"));
        } catch (DNIException e) {
            fail("Unexpected DNIException: " + e.getMessage());
        }
    }

    @Test
    public void testValidWithAccentedLetter() {
        try {
            // Valid DNI with accented letter: 12345678Ñ
            assertTrue("Valid DNI with accented letter should pass validation", DNIValidation.isValidDNI("12345678Ñ"));
        } catch (DNIException e) {
            fail("Unexpected DNIException: " + e.getMessage());
        }
    }

    @Test
    public void testValidWithLeadingZeros() {
        try {
            // Valid DNI with leading zeros: 00123456Z
            assertTrue("Valid DNI with leading zeros should pass validation", DNIValidation.isValidDNI("00123456Z"));
        } catch (DNIException e) {
            fail("Unexpected DNIException: " + e.getMessage());
        }
    }

    @Test
    public void testValidWithTrailingSpaces() {
        try {
            // Valid DNI with trailing spaces: 12345678Z  
            assertTrue("Valid DNI with trailing spaces should pass validation", DNIValidation.isValidDNI("12345678Z  "));
        } catch (DNIException e) {
            fail("Unexpected DNIException: " + e.getMessage());
        }
    }

    @Test
    public void testValidWithLeadingAndTrailingSpaces() {
        try {
            // Valid DNI with leading and trailing spaces:   12345678Z   
            assertTrue("Valid DNI with leading and trailing spaces should pass validation", DNIValidation.isValidDNI("   12345678Z   "));
        } catch (DNIException e) {
            fail("Unexpected DNIException: " + e.getMessage());
        }
    }
}
