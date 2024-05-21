package CardTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import exception.CardException;
import validation.CardValidation;

public class CardValidatorTest {

	@Test
	public void testValidCreditCard() {
		CardValidation validator = new CardValidation();
		try {
			assertTrue("Valid Visa card should pass", validator.CreditCardValidation("4532015112830366", "12/25", 123));
			assertTrue("Valid MasterCard should pass",
					validator.CreditCardValidation("5105105105105100", "12/25", 123));
			assertTrue("Valid Amex card should pass", validator.CreditCardValidation("371449635398431", "12/25", 1234));
		} catch (CardException e) {
			fail("Validation should not fail for valid credit card details. Error message: " + e.getMessage());
		}
	}

	@Test
	public void testInvalidCreditCardNumber() {
		CardValidation validator = new CardValidation();
		try {
			validator.CreditCardValidation("1234567890123456", "12/25", 123);
			fail("Validation should fail for invalid credit card number. Error message: The credit card number '1234567890123456' is invalid.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid credit card number"));
		}

		try {
			validator.CreditCardValidation("453201511283036", "12/25", 123); // 1 digit short
			fail("Validation should fail for short credit card number. Error message: The credit card number '453201511283036' is invalid.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid credit card number"));
		}

		try {
			validator.CreditCardValidation("45320151128303666", "12/25", 123); // 1 digit too long
			fail("Validation should fail for long credit card number. Error message: The credit card number '45320151128303666' is invalid.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid credit card number"));
		}
	}

	@Test
	public void testInvalidExpirationDate() {
		CardValidation validator = new CardValidation();
		try {
			validator.CreditCardValidation("4532015112830366", "13/25", 123);
			fail("Validation should fail for invalid expiration month. Error message: Invalid expiration date format.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid expiration date format"));
		}

		try {
			validator.CreditCardValidation("4532015112830366", "12/2025", 123);
			fail("Validation should fail for invalid expiration year format. Error message: Invalid expiration date format.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid expiration date format"));
		}

		try {
			validator.CreditCardValidation("4532015112830366", "12/21", 123);
			fail("Validation should fail for past expiration date. Error message: Card is expired.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Card is expired"));
		}
	}

	@Test
	public void testInvalidCVV() {
		CardValidation validator = new CardValidation();
		try {
			validator.CreditCardValidation("4532015112830366", "12/25", 12);
			fail("Validation should fail for short CVV. Error message: Invalid CVV.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid CVV"));
		}

		try {
			validator.CreditCardValidation("4532015112830366", "12/25", 12345);
			fail("Validation should fail for long CVV. Error message: Invalid CVV.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid CVV"));
		}

		try {
			validator.CreditCardValidation("371449635398431", "12/25", 123);
			fail("Validation should fail for short CVV for Amex. Error message: Invalid CVV.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid CVV"));
		}

		try {
			validator.CreditCardValidation("371449635398431", "12/25", 12345);
			fail("Validation should fail for long CVV for Amex. Error message: Invalid CVV.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid CVV"));
		}
	}

	@Test
	public void testNullOrEmptyFields() {
		CardValidation validator = new CardValidation();

		try {
			validator.CreditCardValidation(null, "12/25", 123);
			fail("Validation should fail for null card number. Error message: Credit card number cannot be null or empty.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Credit card number cannot be null or empty"));
		}

		try {
			validator.CreditCardValidation("", "12/25", 123);
			fail("Validation should fail for empty card number. Error message: Credit card number cannot be null or empty.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Credit card number cannot be null or empty"));
		}

		try {
			validator.CreditCardValidation("4532015112830366", null, 123);
			fail("Validation should fail for null expiration date. Error message: Expiration date cannot be null or empty.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Expiration date cannot be null or empty"));
		}

		try {
			validator.CreditCardValidation("4532015112830366", "", 123);
			fail("Validation should fail for empty expiration date. Error message: Expiration date cannot be null or empty.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Expiration date cannot be null or empty"));
		}

		try {
			validator.CreditCardValidation("4532015112830366", "12/25", 0);
			fail("Validation should fail for zero CVV. Error message: Invalid CVV.");
		} catch (CardException e) {
			assertTrue(e.getMessage().contains("Invalid CVV"));
		}
	}
}
