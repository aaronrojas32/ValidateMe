package validation;

import exception.ValidationException;

/**
 * The IPValidator class provides methods to validate IP addresses both in
 * string format and integer format.
 * 
 * @version 1.0
 * @since 2024-05-25
 * @author Aaron Rojas
 */
public class IPValidation {

	/**
	 * Default constructor.
	 */
	public IPValidation() {

	}

	/**
	 * Validates if the given string is a valid IPv4 address.
	 * 
	 * @param string The string to be checked.
	 * @return true if the string is a valid IPv4 address.
	 * @throws ValidationException if the string is not a valid IPv4 address.
	 */
	public boolean validateIP(String string) throws ValidationException {
		if (string == null) {
			throw new ValidationException("IP address is null");
		}

		String[] parts = string.split("\\.");
		if (parts.length != 4) {
			throw new ValidationException("IP address does not have four parts");
		}

		for (String part : parts) {
			try {
				int num = Integer.parseInt(part);
				if (num < 0 || num > 255) {
					throw new ValidationException("IP address part out of range: " + part);
				}
			} catch (NumberFormatException e) {
				throw new ValidationException("IP address part is not a number: " + part);
			}
		}

		return true;
	}

	/**
	 * Validates if the given integer can be converted to a valid IPv4 address.
	 * 
	 * @param ip The integer to be checked.
	 * @return true if the integer can be converted to a valid IPv4 address.
	 * @throws ValidationException if the integer cannot be converted to a valid
	 *                             IPv4 address.
	 */
	public boolean validateIPAsNumber(long ip) throws ValidationException {
		if (ip < 0 || ip > 0xFFFFFFFFL) {
			throw new ValidationException("IP integer is out of valid range");
		}

		return true;
	}
}
