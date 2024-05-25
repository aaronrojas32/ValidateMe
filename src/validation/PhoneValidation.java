package validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import exception.ValidationException;

public class PhoneValidation {

	/**
	 * Validates a phone number.
	 * 
	 * @param phoneNumber The phone number to validate.
	 * @return true if the phone number is valid, false otherwise.
	 * @throws ValidationException if the phone number is not valid.
	 */
	public static boolean validatePhoneNumber(String phoneNumber) throws ValidationException {
		if (phoneNumber == null) {
			throw new ValidationException("Phone number is null");
		}
		if (phoneNumber.isEmpty()) {
			throw new ValidationException("Phone number is empty");
		}
		if (phoneNumber.length() < 10) {
			throw new ValidationException("Invalid phone number: " + phoneNumber);
		}
		PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
		try {
			Phonenumber.PhoneNumber parsedPhoneNumber = phoneNumberUtil.parse(phoneNumber, null);
			return phoneNumberUtil.isValidNumber(parsedPhoneNumber);
		} catch (NumberParseException e) {
			throw new ValidationException("Invalid phone number: " + phoneNumber);
		}
	}
}
