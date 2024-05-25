package validation;

import exception.ValidationException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The StringValidation class provides methods to validate strings for various
 * conditions such as being non-empty, having a valid length, being numeric,
 * being alphanumeric, and being a valid URL.
 * 
 * @version 1.0
 * @since 2024-05-25
 * @author Aarón Rojas
 */
public class StringValidation {

	/**
	 * Default constructor.
	 */
	public StringValidation() {

	}

	/**
	 * Checks if the given string is not empty or null.
	 * 
	 * @param string The string to be checked.
	 * @return true if the string is not empty or null.
	 * @throws ValidationException if the string is empty or null.
	 */
	public boolean isNotEmpty(String string) throws ValidationException {
		if (string == null || string.trim().isEmpty()) {
			throw new ValidationException("String is empty, null, or only whitespace");
		}
		return true;
	}

	/**
	 * Checks if the given string has a valid length within the specified bounds.
	 * 
	 * @param string The string to be checked.
	 * @param min    The minimum length of the string.
	 * @param max    The maximum length of the string.
	 * @return true if the string length is within the specified bounds.
	 * @throws ValidationException if the string length is less than min or greater
	 *                             than max.
	 */
	public boolean hasValidLength(String string, int min, int max) throws ValidationException {
		if (string == null) {
			throw new ValidationException("String is null");
		}

		int length = string.length();

		if (length < min || length > max) {
			throw new ValidationException("String length is not valid");
		}

		return true;
	}

	/**
	 * Checks if the given string is numeric.
	 * 
	 * @param string The string to be checked.
	 * @return true if the string is numeric.
	 * @throws ValidationException if the string is not numeric.
	 */
	public boolean isNumeric(String string) throws ValidationException {
		if (string == null || !string.matches("\\d+")) {
			throw new ValidationException("String is not numeric");
		}
		return true;
	}

	/**
	 * Checks if the given string is alphanumeric.
	 * 
	 * @param string The string to be checked.
	 * @return true if the string is alphanumeric.
	 * @throws ValidationException if the string is not alphanumeric.
	 */
	public boolean isAlphanumeric(String string) throws ValidationException {
		if (string == null || !string.matches("[a-zA-Z0-9]+")) {
			throw new ValidationException("String is not alphanumeric");
		}
		return true;
	}

	/**
	 * Checks if the given string is a valid URL.
	 * 
	 * @param string The string to be checked.
	 * @return true if the string is a valid URL.
	 * @throws ValidationException if the string is not a valid URL.
	 */
	public boolean isValidURL(String string) throws ValidationException {
		if (string == null || string.trim().isEmpty()) {
			throw new ValidationException("URL string is null or empty");
		}
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(string);
			if (url.getProtocol() == null || url.getHost() == null || url.getHost().isEmpty()) {
				throw new ValidationException("String is not a valid URL");
			}
		} catch (MalformedURLException e) {
			throw new ValidationException("String is not a valid URL");
		}
		return true;
	}
}