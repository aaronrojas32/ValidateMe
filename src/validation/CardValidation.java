package validation;

import exception.CardException;
import java.util.regex.Pattern;

/**
 * The CardValidation class provides methods for validating credit card details.
 * This class includes methods to validate credit card numbers using the Luhn
 * algorithm, as well as additional validations for expiration dates and CVV
 * codes.
 *
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class CardValidation {

	private static final Pattern VISA_PATTERN = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?$");
	private static final Pattern MASTERCARD_PATTERN = Pattern.compile("^5[1-5][0-9]{14}$");
	private static final Pattern AMEX_PATTERN = Pattern.compile("^3[47][0-9]{13}$");

	/**
	 * Validates the credit card number, expiration date, and CVV.
	 * 
	 * @param number The credit card number to validate.
	 * @param date   The expiration date of the card in the format MM/YY.
	 * @param cvv    The CVV (Card Verification Value) code.
	 * @return true if the credit card details are valid.
	 * @throws CardException if any of the credit card details are invalid.
	 */
	public boolean CreditCardValidation(String number, String date, int cvv) throws CardException {
		isValidCreditCardNumber(number);
		isValidExpiryDate(date);
		isValidCVV(number, cvv);
		return true;
	}

	/**
	 * Validates a credit card number using the Luhn algorithm.
	 * 
	 * @param cardNumber The credit card number to validate.
	 * @throws CardException if the card number is invalid.
	 */
	private void isValidCreditCardNumber(String cardNumber) throws CardException {
		isValidPattern(cardNumber);
		isValidLuhn(cardNumber);
	}

	/**
	 * Checks if the credit card number matches known patterns for Visa, MasterCard,
	 * or Amex.
	 * 
	 * @param cardNumber The credit card number to check.
	 * @throws CardException if the card number does not match any known pattern.
	 */
	private void isValidPattern(String cardNumber) throws CardException {
		if (!VISA_PATTERN.matcher(cardNumber).matches() && !MASTERCARD_PATTERN.matcher(cardNumber).matches()
				&& !AMEX_PATTERN.matcher(cardNumber).matches()) {
			throw new CardException("Invalid credit card number pattern");
		}
	}

	/**
	 * Implements the Luhn algorithm to validate the credit card number.
	 * 
	 * @param cardNumber The credit card number to validate.
	 * @throws CardException if the card number fails the Luhn check.
	 */
	private void isValidLuhn(String cardNumber) throws CardException {
		int nDigits = cardNumber.length();
		int sum = 0;
		boolean isSecond = false;

		for (int i = nDigits - 1; i >= 0; i--) {
			int d = cardNumber.charAt(i) - '0';

			if (isSecond)
				d = d * 2;

			sum += d / 10;
			sum += d % 10;

			isSecond = !isSecond;
		}

		if (sum % 10 != 0) {
			throw new CardException("Invalid credit card number based on Luhn algorithm");
		}
	}

	/**
	 * Validates the expiration date of the credit card.
	 * 
	 * @param date The expiration date in the format MM/YY.
	 * @throws CardException if the expiration date is invalid.
	 */
	private void isValidExpiryDate(String date) throws CardException {
		if (date == null || !date.matches("^(0[1-9]|1[0-2])\\/([0-9]{2})$")) {
			throw new CardException("Invalid expiration date format");
		}
		// Additional date validation logic can be added here, e.g., checking if the
		// date is in the future
	}

	/**
	 * Validates the CVV code.
	 * 
	 * @param cardNumber The credit card number to determine the type of card.
	 * @param cvv        The CVV code to validate.
	 * @throws CardException if the CVV code is invalid.
	 */
	private void isValidCVV(String cardNumber, int cvv) throws CardException {
		String cvvStr = String.valueOf(cvv);
		if ((VISA_PATTERN.matcher(cardNumber).matches() || MASTERCARD_PATTERN.matcher(cardNumber).matches())
				&& cvvStr.length() != 3) {
			throw new CardException("Invalid CVV code for Visa or MasterCard");
		} else if (AMEX_PATTERN.matcher(cardNumber).matches() && cvvStr.length() != 4) {
			throw new CardException("Invalid CVV code for American Express");
		}
	}
}
