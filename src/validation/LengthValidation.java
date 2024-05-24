package validation;

import exception.LengthException;

import java.util.List;

/**
 * A utility class for length validation of strings, arrays, and lists.
 * 
 * @version 1.0
 * @since 2024-05-24
 * @author Aaron Rojas
 */
public class LengthValidation {

    /**
     * Validate a string with spaces against a maximum length.
     *
     * @param string    The string to validate
     * @param maxLength The maximum length allowed
     * @return true if the string is valid, otherwise false
     * @throws LengthException if the string is null or exceeds the maximum length
     */
    public boolean validateStringWithSpaces(String string, int maxLength) throws LengthException {

        if (string == null) {
            throw new LengthException("The string is null");
        }

        if (string.length() > maxLength) {
            throw new LengthException("The string length is: " + string.length() + " and the max is: " + maxLength);
        }

        return true;
    }

    /**
     * Validate a string without spaces against a maximum length.
     *
     * @param string    The string to validate
     * @param maxLength The maximum length allowed
     * @return true if the string is valid, otherwise false
     * @throws LengthException if the string is null or exceeds the maximum length
     */
    public boolean validateStringWithoutSpaces(String string, int maxLength) throws LengthException {

        if (string == null) {
            throw new LengthException("The string is null");
        }

        // Remove white spaces from the string before checking length
        String stringWithoutSpaces = string.replaceAll("\\s", "");
        if (stringWithoutSpaces.length() > maxLength) {
            throw new LengthException("The string length is: " + stringWithoutSpaces.length() + " and the max is: " + maxLength);
        }

        return true;
    }

    /**
     * Validate the length of an array against a maximum length.
     *
     * @param array     The array to validate
     * @param maxLength The maximum length allowed
     * @return true if the array is valid, otherwise false
     * @throws LengthException if the array is null or exceeds the maximum length
     */
    public boolean validateArrayLength(Object[] array, int maxLength) throws LengthException {
        if (array == null) {
            throw new LengthException("The array is null");
        }

        if (array.length > maxLength) {
            throw new LengthException("The array length is: " + array.length + " and the max is: " + maxLength);
        }

        return true;
    }

    /**
     * Validate the length of a list against a maximum length.
     *
     * @param list      The list to validate
     * @param maxLength The maximum length allowed
     * @return true if the list is valid, otherwise false
     * @throws LengthException if the list is null or exceeds the maximum length
     */
    public <T> boolean validateListLength(List<T> list, int maxLength) throws LengthException {
        if (list == null) {
            throw new LengthException("The list is null");
        }

        if (list.size() > maxLength) {
            throw new LengthException("The list size is: " + list.size() + " and the max is: " + maxLength);
        }

        return true;
    }

    /**
     * Validate the length of a string against a minimum length.
     *
     * @param string    The string to validate
     * @param minLength The minimum length required
     * @return true if the string is valid, otherwise false
     * @throws LengthException if the string is null or does not meet the minimum length requirement
     */
    public boolean validateMinimumLength(String string, int minLength) throws LengthException {
        if (string == null) {
            throw new LengthException("The string is null");
        }

        if (string.length() < minLength) {
            throw new LengthException("The string length is: " + string.length() + " and the min required is: " + minLength);
        }

        return true;
    }

    /**
     * Validate the length of a string within a specified range.
     *
     * @param string    The string to validate
     * @param minLength The minimum length required
     * @param maxLength The maximum length allowed
     * @return true if the string is valid, otherwise false
     * @throws LengthException if the string is null or does not meet the length range requirements
     */
    public boolean validateStringLengthInRange(String string, int minLength, int maxLength) throws LengthException {
        if (string == null) {
            throw new LengthException("The string is null");
        }

        int length = string.length();
        if (length < minLength || length > maxLength) {
            throw new LengthException("The string length is: " + length + ", which is not within the range [" + minLength + ", " + maxLength + "]");
        }

        return true;
    }

    /**
     * Validate the length of an array within a specified range.
     *
     * @param array     The array to validate
     * @param minLength The minimum length required
     * @param maxLength The maximum length allowed
     * @return true if the array is valid, otherwise false
     * @throws LengthException if the array is null or does not meet the length range requirements
     */
    public boolean validateArrayLengthInRange(Object[] array, int minLength, int maxLength) throws LengthException {
        if (array == null) {
            throw new LengthException("The array is null");
        }

        int length = array.length;
        if (length < minLength || length > maxLength) {
            throw new LengthException("The array length is: " + length + ", which is not within the range [" + minLength + ", " + maxLength + "]");
        }

        return true;
    }

    /**
     * Validate the size of a list within a specified range.
     *
     * @param list      The list to validate
     * @param minLength The minimum size required
     * @param maxLength The maximum size allowed
     * @return true if the list is valid, otherwise false
     * @throws LengthException if the list is null or does not meet the size range requirements
     */
    public <T> boolean validateListSizeInRange(List<T> list, int minLength, int maxLength) throws LengthException {
        if (list == null) {
            throw new LengthException("The list is null");
        }

        int size = list.size();
        if (size < minLength || size > maxLength) {
            throw new LengthException("The list size is: " + size + ", which is not within the range [" + minLength + ", " + maxLength + "]");
        }

        return true;
    }
}