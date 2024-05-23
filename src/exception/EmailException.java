package exception;

/**
 * The EmailException class represents an exception related to email operations.
 * This exception may be thrown in situations where there are errors or issues
 * with email validation, processing, or other email-related operations.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class EmailException extends Exception {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for EmailException. Creates a new instance of
	 * EmailException with no detailed message.
	 */
	public EmailException() {

	}

	/**
	 * Constructor for EmailException with a detailed message.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 */
	public EmailException(String message) {
		super(message);
	}

	/**
	 * Constructor for EmailException with a root cause.
	 * 
	 * @param cause The root cause of the exception.
	 */
	public EmailException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for EmailException with a detailed message and a root cause.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 * @param cause   The root cause of the exception.
	 */
	public EmailException(String message, Throwable cause) {
		super(message, cause);
	}
}