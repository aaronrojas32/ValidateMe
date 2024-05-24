package exceptionTest;

import static org.junit.Assert.*;
import org.junit.Test;

import exception.CardException;
import exception.DNIException;
import exception.DateException;
import exception.EmailException;
import exception.HourException;
import exception.LengthException;
import exception.PhoneException;

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
	public void testDNIException() {
		try {
			throw new DNIException("Custom Length Exception");
		} catch (DNIException e) {
			assertNotNull("LengthException should not be null", e);
			assertEquals("Custom Length Exception", e.getMessage());
			assertNull("LengthException cause should be null", e.getCause());
		}

		try {
			throw new DNIException(new NullPointerException("Null Pointer"));
		} catch (DNIException e) {
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
	
	 @Test
	    public void testEmailException() {
	        try {
	            throw new EmailException("Custom Email Exception");
	        } catch (EmailException e) {
	            assertNotNull("EmailException should not be null", e);
	            assertEquals("Custom Email Exception", e.getMessage());
	            assertNull("EmailException cause should be null", e.getCause());
	        }

	        try {
	            throw new EmailException(new IllegalArgumentException("Illegal Argument"));
	        } catch (EmailException e) {
	            assertNotNull("EmailException should not be null", e);
	            assertEquals("java.lang.IllegalArgumentException: Illegal Argument", e.getMessage());
	            assertNotNull("EmailException cause should not be null", e.getCause());
	            assertEquals("Illegal Argument", e.getCause().getMessage());
	        }
	    }

	    @Test
	    public void testPhoneException() {
	        try {
	            throw new PhoneException("Custom Phone Exception");
	        } catch (PhoneException e) {
	            assertNotNull("PhoneException should not be null", e);
	            assertEquals("Custom Phone Exception", e.getMessage());
	            assertNull("PhoneException cause should be null", e.getCause());
	        }

	        try {
	            throw new PhoneException(new NullPointerException("Null Pointer"));
	        } catch (PhoneException e) {
	            assertNotNull("PhoneException should not be null", e);
	            assertEquals("java.lang.NullPointerException: Null Pointer", e.getMessage());
	            assertNotNull("PhoneException cause should not be null", e.getCause());
	            assertEquals("Null Pointer", e.getCause().getMessage());
	        }
	    }
	    
	    @Test
	    public void testLengthException() {
	        try {
	            throw new LengthException("Custom Phone Exception");
	        } catch (LengthException e) {
	            assertNotNull("PhoneException should not be null", e);
	            assertEquals("Custom Phone Exception", e.getMessage());
	            assertNull("PhoneException cause should be null", e.getCause());
	        }

	        try {
	            throw new LengthException(new NullPointerException("Null Pointer"));
	        } catch (LengthException e) {
	            assertNotNull("PhoneException should not be null", e);
	            assertEquals("java.lang.NullPointerException: Null Pointer", e.getMessage());
	            assertNotNull("PhoneException cause should not be null", e.getCause());
	            assertEquals("Null Pointer", e.getCause().getMessage());
	        }
	    }
}
