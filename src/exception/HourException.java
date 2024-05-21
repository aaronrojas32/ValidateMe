package exception;

/**
 * The HourException class represents an exception related to hour operations.
 * This exception may be thrown in situations where there are errors or issues
 * with hour manipulation, parsing, or validation.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class HourException extends Exception {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for HourException. Creates a new instance of
	 * HourException with no detailed message.
	 */
	public HourException() {
		super();
	}

	/**
	 * Constructor for HourException with a detailed message.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 */
	public HourException(String message) {
		super(message);
	}

	/**
	 * Constructor for HourException with a root cause.
	 * 
	 * @param cause The root cause of the exception.
	 */
	public HourException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for HourException with a detailed message and a root cause.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 * @param cause   The root cause of the exception.
	 */
	public HourException(String message, Throwable cause) {
		super(message, cause);
	}
}
