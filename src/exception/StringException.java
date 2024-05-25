package exception;

/**
 * The StringException class represents an exception related to string 
 * operations. This exception may be thrown in situations where there are errors
 * or issues with string validation, processing, or other string-related operations.
 * 
 * @version 1.0
 * @since 2024-05-20
 * @autor Aarón Rojas
 */
public class StringException extends Exception {

    /**
     * Unique identifier for serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor for StringException. Creates a new instance of
     * StringException with no detailed message.
     */
    public StringException() {
        super();
    }

    /**
     * Constructor for StringException with a detailed message.
     * 
     * @param message The detailed message describing the cause of the exception.
     */
    public StringException(String message) {
        super(message);
    }

    /**
     * Constructor for StringException with a root cause.
     * 
     * @param cause The root cause of the exception.
     */
    public StringException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor for StringException with a detailed message and a root cause.
     * 
     * @param message The detailed message describing the cause of the exception.
     * @param cause   The root cause of the exception.
     */
    public StringException(String message, Throwable cause) {
        super(message, cause);
    }
}