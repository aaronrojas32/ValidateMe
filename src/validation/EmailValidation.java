package validation;

import exception.ValidationException;
import java.util.regex.Pattern;

/**
 * This class provides email validation functionality.
 * 
 * @version 1.0
 * @since 2024-05-24
 * @author Aaron Rojas
 */
public class EmailValidation {

    // Regular expression pattern for validating email addresses
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
	 * Default constructor.
	 */
    public EmailValidation() {
    	
    }
    
    /**
     * Validates the given email string.
     *
     * @param email the email string to be validated
     * @return true if the email is valid
     * @throws ValidationException if the email is null, empty, or does not match the email pattern
     */
    public boolean StringEmailValidation(String email) throws ValidationException {
        // Check if the email is null or empty
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("Email cannot be null or empty");
        }
        
        // Check if the email matches the defined pattern
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException("Invalid email format");
        }

        // If all checks pass, the email is valid
        return true;
    }
}
