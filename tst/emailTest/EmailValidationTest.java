package emailTest;

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
            assertTrue(emailValidation.StringEmailValidation("example@example.com"));
        } catch (EmailException e) {
            fail("EmailException was thrown for a valid email");
        }
    }

    @Test
    public void testInvalidEmailWithoutAtSymbol() {
        try {
            emailValidation.StringEmailValidation("example.com");
            fail("EmailException was not thrown for an invalid email without @ symbol");
        } catch (EmailException e) {
            assertTrue(e.getMessage().contains("Invalid email format"));
        }
    }

    @Test
    public void testInvalidEmailWithoutDomain() {
        try {
            emailValidation.StringEmailValidation("example@");
            fail("EmailException was not thrown for an invalid email without domain");
        } catch (EmailException e) {
            assertTrue(e.getMessage().contains("Invalid email format"));
        }
    }

    @Test
    public void testNullEmail() {
        try {
            emailValidation.StringEmailValidation(null);
            fail("EmailException was not thrown for a null email");
        } catch (EmailException e) {
            assertTrue(e.getMessage().contains("Email cannot be null or empty"));
        }
    }

    @Test
    public void testEmptyEmail() {
        try {
            emailValidation.StringEmailValidation("");
            fail("EmailException was not thrown for an empty email");
        } catch (EmailException e) {
            assertTrue(e.getMessage().contains("Email cannot be null or empty"));
        }
    }

    @Test
    public void testEmailWithSpaces() {
        try {
            emailValidation.StringEmailValidation("   ");
            fail("EmailException was not thrown for an email with only spaces");
        } catch (EmailException e) {
            assertTrue(e.getMessage().contains("Email cannot be null or empty"));
        }
    }
}
