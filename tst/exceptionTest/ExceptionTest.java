package exceptionTest;
import static org.junit.Assert.*;
import org.junit.Test;
import exception.DateException;
import exception.LengthException;

public class ExceptionTest {

    @Test
    public void testDateException() {
        try {
            throw new DateException("Custom Date Exception");
        } catch (DateException e) {
            assertNotNull("DateException should not be null", e);
            assertEquals("Custom Date Exception", e.getMessage());
            assertNull("DateException cause should be null", e.getCause());
        }
        
        try {
            throw new DateException(new IllegalArgumentException("Illegal Argument"));
        } catch (DateException e) {
            assertNotNull("DateException should not be null", e);
            assertEquals("java.lang.IllegalArgumentException: Illegal Argument", e.getMessage());
            assertNotNull("DateException cause should not be null", e.getCause());
            assertEquals("Illegal Argument", e.getCause().getMessage());
        }
    }

    @Test
    public void testLengthException() {
        try {
            throw new LengthException("Custom Length Exception");
        } catch (LengthException e) {
            assertNotNull("LengthException should not be null", e);
            assertEquals("Custom Length Exception", e.getMessage());
            assertNull("LengthException cause should be null", e.getCause());
        }
        
        try {
            throw new LengthException(new NullPointerException("Null Pointer"));
        } catch (LengthException e) {
            assertNotNull("LengthException should not be null", e);
            assertEquals("java.lang.NullPointerException: Null Pointer", e.getMessage());
            assertNotNull("LengthException cause should not be null", e.getCause());
            assertEquals("Null Pointer", e.getCause().getMessage());
        }
    }
}
