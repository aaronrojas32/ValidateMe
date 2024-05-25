package validationTest;

import static org.junit.Assert.*;
import org.junit.Test;
import validation.StringValidation;
import exception.ValidationException;

public class UrlValidationTest {

	private StringValidation stringValidation = new StringValidation();

	@Test
	public void testValidURL() {
		try {
			assertTrue(stringValidation.isValidURL("https://www.example.com"));
			assertTrue(stringValidation.isValidURL("http://example.org"));
			assertTrue(stringValidation.isValidURL("https://sub.domain.example.com/path?query=string#fragment"));
		} catch (ValidationException e) {
			fail("ValidationException was thrown for a valid URL: " + e.getMessage());
		}
	}

	@Test
	public void testInvalidURL() {
		try {
			stringValidation.isValidURL("invalid-url");
			fail("ValidationException was not thrown for an invalid URL");
		} catch (ValidationException e) {
			assertEquals("String is not a valid URL", e.getMessage());
		}

		try {
			stringValidation.isValidURL("http://");
			fail("ValidationException was not thrown for an invalid URL");
		} catch (ValidationException e) {
			assertEquals("String is not a valid URL", e.getMessage());
		}

		try {
			stringValidation.isValidURL("ftp://");
			fail("ValidationException was not thrown for an invalid URL");
		} catch (ValidationException e) {
			assertEquals("String is not a valid URL", e.getMessage());
		}
	}

	@Test
	public void testNullOrEmptyURL() {
		try {
			stringValidation.isValidURL(null);
			fail("ValidationException was not thrown for a null URL");
		} catch (ValidationException e) {
			assertEquals("URL string is null or empty", e.getMessage());
		}

		try {
			stringValidation.isValidURL("");
			fail("ValidationException was not thrown for an empty URL");
		} catch (ValidationException e) {
			assertEquals("URL string is null or empty", e.getMessage());
		}

		try {
			stringValidation.isValidURL("   ");
			fail("ValidationException was not thrown for a whitespace URL");
		} catch (ValidationException e) {
			assertEquals("URL string is null or empty", e.getMessage());
		}
	}
}
