package exceptionTest;

import static org.junit.Assert.*;
import org.junit.Test;

import exception.ValidationException;
public class ExceptionTest {

	@Test
	public void testDateException() {
		try {
			throw new ValidationException("Custom Date Exception");
		} catch (ValidationException e) {
			assertNotNull("DateException should not be null", e);
			assertEquals("Custom Date Exception", e.getMessage());
			assertNull("DateException cause should be null", e.getCause());
		}

		try {
			throw new ValidationException(new IllegalArgumentException("Illegal Argument"));
		} catch (ValidationException e) {
			assertNotNull("DateException should not be null", e);
			assertEquals("java.lang.IllegalArgumentException: Illegal Argument", e.getMessage());
			assertNotNull("DateException cause should not be null", e.getCause());
			assertEquals("Illegal Argument", e.getCause().getMessage());
		}
	}
}
