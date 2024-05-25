package exception;

/**
 * The CardException class represents an exception related to credit card
 * operations. This exception may be thrown in situations where there are errors
 * or issues with credit card validation, processing, or other credit
 * card-related operations.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class ValidationException extends Exception {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for CardException. Creates a new instance of
	 * CardException with no detailed message.
	 */
	public ValidationException() {

	}

	/**
	 * Constructor for CardException with a detailed message.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Constructor for CardException with a root cause.
	 * 
	 * @param cause The root cause of the exception.
	 */
	public ValidationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for CardException with a detailed message and a root cause.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 * @param cause   The root cause of the exception.
	 */
	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}