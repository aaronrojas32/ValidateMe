package exceptionTest;

import static org.junit.Assert.*;
import org.junit.Test;

import exception.CardException;
import exception.DateException;
import exception.LengthException;
import exception.HourException;

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

	@Test
	public void testHourException() {
		try {
			throw new HourException("Custom Hour Exception");
		} catch (HourException e) {
			assertNotNull("HourException should not be null", e);
			assertEquals("Custom Hour Exception", e.getMessage());
			assertNull("HourException cause should be null", e.getCause());
		}

		try {
			throw new HourException(new IllegalArgumentException("Illegal Argument"));
		} catch (HourException e) {
			assertNotNull("HourException should not be null", e);
			assertEquals("java.lang.IllegalArgumentException: Illegal Argument", e.getMessage());
			assertNotNull("HourException cause should not be null", e.getCause());
			assertEquals("Illegal Argument", e.getCause().getMessage());
		}
	}

	@Test
	public void testCardException() {
		try {
			throw new CardException("Custom Card Exception");
		} catch (CardException e) {
			assertNotNull("CardException should not be null", e);
			assertEquals("Custom Card Exception", e.getMessage());
			assertNull("CardException cause should be null", e.getCause());
		}

		try {
			throw new CardException(new NullPointerException("Null Pointer"));
		} catch (CardException e) {
			assertNotNull("CardException should not be null", e);
			assertEquals("java.lang.NullPointerException: Null Pointer", e.getMessage());
			assertNotNull("CardException cause should be null", e.getCause());
			assertEquals("Null Pointer", e.getCause().getMessage());
		}
	}
}
