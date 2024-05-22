package exception;

/**
 * The DNIException class represents an exception related to DNI operations.
 * This exception may be thrown in situations where there are errors or issues
 * with DNI manipulation, parsing, or validation.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class DNIException extends Exception {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for DNIException. Creates a new instance of DNIException
	 * with no detailed message.
	 */
	public DNIException() {
		super();
	}

	/**
	 * Constructor for DNIException with a detailed message.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 */
	public DNIException(String message) {
		super(message);
	}

	/**
	 * Constructor for DNIException with a root cause.
	 * 
	 * @param cause The root cause of the exception.
	 */
	public DNIException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for DNIException with a detailed message and a root cause.
	 * 
	 * @param message The detailed message describing the cause of the exception.
	 * @param cause   The root cause of the exception.
	 */
	public DNIException(String message, Throwable cause) {
		super(message, cause);
	}
}