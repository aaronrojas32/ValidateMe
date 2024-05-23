package exception;

/**
 * The PhoneException class represents an exception related to phone number operations.
 * This exception may be thrown in situations where there are errors or issues
 * with phone number manipulation, validation, or parsing.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class PhoneException extends Exception {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for PhoneException. Creates a new instance of
	 * PhoneException with no detailed message.
	 */
	public PhoneException() {

	}

	/**
	 * Constructor for PhoneException with a detailed message.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 */
	public PhoneException(String message) {
		super(message);
	}

	/**
	 * Constructor for PhoneException with a root cause.
	 * 
	 * @param cause The root cause of the exception.
	 */
	public PhoneException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for PhoneException with a detailed message and a root cause.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 * @param cause   The root cause of the exception.
	 */
	public PhoneException(String message, Throwable cause) {
		super(message, cause);
	}
}