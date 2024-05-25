package validationTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import exception.EmailException;
import validation.EmailValidation;

public class EmailValidationTest {

    private EmailValidation emailValidation;

    @Before
    public void setUp() {
        emailValidation = new EmailValidation();
    }

    @Test
    public void testValidEmail() {
        try {
            assertTrue("Valid email was not accepted", emailValidation.StringEmailValidation("example@example.com"));
        } catch (EmailException e) {
            fail("EmailException was thrown for a valid email");
        }
    }

    @Test
    public void testInvalidEmailWithoutAtSymbol() {
        try {
            emailValidation.StringEmailValidation("example.com");
            fail("Invalid email without @ symbol was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Invalid email format"));
        }
    }

    @Test
    public void testInvalidEmailWithoutDomain() {
        try {
            emailValidation.StringEmailValidation("example@");
            fail("Invalid email without domain was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Invalid email format"));
        }
    }

    @Test
    public void testNullEmail() {
        try {
            emailValidation.StringEmailValidation(null);
            fail("Null email was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Email cannot be null or empty"));
        }
    }

    @Test
    public void testEmptyEmail() {
        try {
            emailValidation.StringEmailValidation("");
            fail("Empty email was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Email cannot be null or empty"));
        }
    }

    @Test
    public void testEmailWithSpaces() {
        try {
            emailValidation.StringEmailValidation("   ");
            fail("Email with only spaces was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Email cannot be null or empty"));
        }
    }

    @Test
    public void testInvalidEmailWithoutLocalPart() {
        try {
            emailValidation.StringEmailValidation("@example.com");
            fail("Invalid email without local part was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Invalid email format"));
        }
    }

    @Test
    public void testInvalidEmailWithInvalidCharacters() {
        try {
            emailValidation.StringEmailValidation("user!example.com");
            fail("Invalid email with invalid characters was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Invalid email format"));
        }
    }

    @Test
    public void testInvalidEmailWithMultipleAtSymbols() {
        try {
            emailValidation.StringEmailValidation("user@example@com");
            fail("Invalid email with multiple @ symbols was accepted");
        } catch (EmailException e) {
            assertTrue("Incorrect exception message", e.getMessage().contains("Invalid email format"));
        }
    }

    @Test
    public void testValidEmailWithSubdomain() {
        try {
            assertTrue("Valid email with subdomain was not accepted", emailValidation.StringEmailValidation("user@example.co.uk"));
        } catch (EmailException e) {
            fail("EmailException was thrown for a valid email with subdomain");
        }
    }

    @Test
    public void testValidEmailWithPlusSymbol() {
        try {
            assertTrue("Valid email with plus symbol was not accepted", emailValidation.StringEmailValidation("user+label@example.com"));
        } catch (EmailException e) {
            fail("EmailException was thrown for a valid email with plus symbol");
        }
    }
}
