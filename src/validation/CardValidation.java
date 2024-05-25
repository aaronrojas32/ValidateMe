package validation;

import java.util.Calendar;
import java.util.regex.Pattern;

import exception.ValidationException;

/**
 * The CardValidation class provides methods for validating credit card details.
 * This class includes methods to validate credit card numbers using the Luhn
 * algorithm, as well as additional validations for expiration dates and CVV
 * codes.
 *
 * @version 1.0
 * @since 2024-05-20 author Aarón Rojas
 */
public class CardValidation {

	private static final Pattern VISA_PATTERN = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?$");
	private static final Pattern MASTERCARD_PATTERN = Pattern.compile("^5[1-5][0-9]{14}$");
	private static final Pattern AMEX_PATTERN = Pattern.compile("^3[47][0-9]{13}$");
	private static final Pattern DISCOVER_PATTERN = Pattern.compile("^6(?:011|5[0-9]{2})[0-9]{12}$");
	private static final Pattern DINERS_CLUB_PATTERN = Pattern.compile("^3(?:0[0-5]|[68][0-9])[0-9]{11}$");

	/**
	 * Default constructor.
	 */
	public CardValidation(){
		
	}
	/**
	 * Validates the credit card number, expiration date, and CVV.
	 * 
	 * @param number The credit card number to validate.
	 * @param date   The expiration date of the card in the format MM/YY.
	 * @param cvv    The CVV (Card Verification Value) code.
	 * @return true if the credit card details are valid.
	 * @throws ValidationException if any of the credit card details are invalid.
	 */
	public boolean CreditCardValidation(String number, String date, int cvv) throws ValidationException {
		isValidCreditCardNumber(number);
		isValidExpiryDate(date);
		isValidCVV(number, cvv);
		return true;
	}

	/**
	 * Validates a credit card number using the Luhn algorithm.
	 * 
	 * @param cardNumber The credit card number to validate.
	 * @throws ValidationException if the card number is invalid.
	 */
	private void isValidCreditCardNumber(String cardNumber) throws ValidationException {
		if (cardNumber == null || cardNumber.isEmpty()) {
			throw new ValidationException("Credit card number cannot be null or empty");
		}
		isValidPattern(cardNumber);
		isValidLuhn(cardNumber);
	}

	/**
	 * Checks if the credit card number matches known patterns for Visa, MasterCard,
	 * Amex, Discover, or Diners Club.
	 * 
	 * @param cardNumber The credit card number to check.
	 * @throws ValidationException if the card number does not match any known pattern.
	 */
	private void isValidPattern(String cardNumber) throws ValidationException {
		if (!VISA_PATTERN.matcher(cardNumber).matches() && !MASTERCARD_PATTERN.matcher(cardNumber).matches()
				&& !AMEX_PATTERN.matcher(cardNumber).matches() && !DISCOVER_PATTERN.matcher(cardNumber).matches()
				&& !DINERS_CLUB_PATTERN.matcher(cardNumber).matches()) {
			throw new ValidationException("Invalid credit card number pattern");
		}
	}

	/**
	 * Implements the Luhn algorithm to validate the credit card number.
	 * 
	 * @param cardNumber The credit card number to validate.
	 * @throws ValidationException if the card number fails the Luhn check.
	 */
	private void isValidLuhn(String cardNumber) throws ValidationException {
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
			throw new ValidationException("Invalid credit card number based on Luhn algorithm");
		}
	}

	/**
	 * Validates the expiration date of the credit card.
	 * 
	 * @param date The expiration date in the format MM/YY.
	 * @throws ValidationException if the expiration date is invalid or in the past.
	 */
	private void isValidExpiryDate(String date) throws ValidationException {
		if (date == null || date.isEmpty()) {
			throw new ValidationException("Expiration date cannot be null or empty");
		}
		if (!date.matches("^(0[1-9]|1[0-2])\\/([0-9]{2})$")) {
			throw new ValidationException("Invalid expiration date format");
		}

		// Parse the expiration date to check if it's in the past
		String[] parts = date.split("/");
		int month = Integer.parseInt(parts[0]);
		int year = Integer.parseInt(parts[1]);

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR) % 100; // Get last two digits of the current year
		int currentMonth = now.get(Calendar.MONTH) + 1; // Month starts from 0

		if (year < currentYear || (year == currentYear && month < currentMonth)) {
			throw new ValidationException("Card is expired");
		}
	}

	/**
	 * Validates the CVV code.
	 * 
	 * @param cardNumber The credit card number to determine the type of card.
	 * @param cvv        The CVV code to validate.
	 * @throws ValidationException if the CVV code is invalid.
	 */
	private void isValidCVV(String cardNumber, int cvv) throws ValidationException {
		String cvvStr = String.valueOf(cvv);
		if ((VISA_PATTERN.matcher(cardNumber).matches() || MASTERCARD_PATTERN.matcher(cardNumber).matches())
				&& (cvvStr.length() != 3 || cvv <= 0)) {
			throw new ValidationException("Invalid CVV for Visa or MasterCard");
		} else if (AMEX_PATTERN.matcher(cardNumber).matches() && (cvvStr.length() != 4 || cvv <= 0)) {
			throw new ValidationException("Invalid CVV for American Express");
		}
	}
}