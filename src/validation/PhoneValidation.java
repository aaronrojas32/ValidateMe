package validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import exception.PhoneException;

public class PhoneValidation {

    /**
     * Validates a phone number.
     * 
     * @param phoneNumber The phone number to validate.
     * @return true if the phone number is valid, false otherwise.
     * @throws PhoneException if the phone number is not valid.
     */
    public static boolean validatePhoneNumber(String phoneNumber) throws PhoneException {
        if (phoneNumber == null) {
            throw new PhoneException("Phone number is null");
        }
        if (phoneNumber.isEmpty()) {
            throw new PhoneException("Phone number is empty");
        }
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber parsedPhoneNumber = phoneNumberUtil.parse(phoneNumber, null);
            return phoneNumberUtil.isValidNumber(parsedPhoneNumber);
        } catch (NumberParseException e) {
            throw new PhoneException("Invalid phone number: " + phoneNumber);
        }
    }
}