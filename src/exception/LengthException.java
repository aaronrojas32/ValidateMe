package exception;

/**
 * The LengthException class represents an exception related to length issues.
 * This exception may be thrown in situations where length constraints are
 * violated, such as when a string or array exceeds a specified length.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class LengthException extends Exception {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for LengthException. Creates a new instance of
	 * LengthException with no detailed message.
	 */
	public LengthException() {

	}

	/**
	 * Constructor for LengthException with a detailed message.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 */
	public LengthException(String message) {
		super(message);
	}

	/**
	 * Constructor for LengthException with a root cause.
	 * 
	 * @param cause The root cause of the exception.
	 */
	public LengthException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for LengthException with a detailed message and a root cause.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 * @param cause   The root cause of the exception.
	 */
	public LengthException(String message, Throwable cause) {
		super(message, cause);
	}
}
