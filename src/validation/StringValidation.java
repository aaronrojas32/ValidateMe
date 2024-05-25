package validation;

import exception.StringException;

/**
 * The StringValidation class provides methods to validate strings for various
 * conditions such as being non-empty, having a valid length, being numeric, 
 * and being alphanumeric.
 * 
 * @version 1.0
 * @since 2024-05-25
 * @author Aarón Rojas
 */
public class StringValidation {
    
    /**
     * Checks if the given string is not empty or null.
     * 
     * @param string The string to be checked.
     * @return true if the string is not empty or null.
     * @throws StringException if the string is empty or null.
     */
	public boolean isNotEmpty(String string) throws StringException {
        if (string == null || string.trim().isEmpty()) {
            throw new StringException("String is empty, null, or only whitespace");
        }
        return true;
    }
    
    /**
     * Checks if the given string has a valid length within the specified bounds.
     * 
     * @param string The string to be checked.
     * @param min The minimum length of the string.
     * @param max The maximum length of the string.
     * @return true if the string length is within the specified bounds.
     * @throws StringException if the string length is less than min or greater than max.
     */
    public boolean hasValidLength(String string, int min, int max) throws StringException {
        if (string == null) {
            throw new StringException("String is null");
        }

        int length = string.length();
        
        if (length < min || length > max) {
            throw new StringException("String length is not valid");
        }
        
        return true;
    }
    
    /**
     * Checks if the given string is numeric.
     * 
     * @param string The string to be checked.
     * @return true if the string is numeric.
     * @throws StringException if the string is not numeric.
     */
    public boolean isNumeric(String string) throws StringException {
        if (string == null || !string.matches("\\d+")) {
            throw new StringException("String is not numeric");
        }
        return true;
    }
    
    /**
     * Checks if the given string is alphanumeric.
     * 
     * @param string The string to be checked.
     * @return true if the string is alphanumeric.
     * @throws StringException if the string is not alphanumeric.
     */
    public boolean isAlphanumeric(String string) throws StringException {
        if (string == null || !string.matches("[a-zA-Z0-9]+")) {
            throw new StringException("String is not alphanumeric");
        }
        return true;
    }
}