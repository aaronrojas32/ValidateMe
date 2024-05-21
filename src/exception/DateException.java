package exception;

/**
 * The DateException class represents an exception related to date operations.
 * This exception may be thrown in situations where there are errors or issues
 * with date manipulation, parsing, or validation.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class DateException extends Exception {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for DateException. Creates a new instance of
	 * DateException with no detailed message.
	 */
	public DateException() {

	}

	/**
	 * Constructor for DateException with a detailed message.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 */
	public DateException(String message) {
		super(message);
	}

	/**
	 * Constructor for DateException with a root cause.
	 * 
	 * @param cause The root cause of the exception.
	 */
	public DateException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for DateException with a detailed message and a root cause.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 * @param cause   The root cause of the exception.
	 */
	public DateException(String message, Throwable cause) {
		super(message, cause);
	}
}
