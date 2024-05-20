package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.*;

/**
 * The DateValidation class provides methods for validating dates.
 * This class includes methods to validate the day, month, year, 
 * and combinations of these components in a date.
 *
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class DateValidation {

	/**
	 * Validates the day value.
	 * @param day The day to validate.
	 * @return true if the day is valid.
	 * @throws DateException if the day is invalid.
	 */
	public boolean dayValidation(int day) throws DateException {
		if (day < 1 || day > 31) {
			throw new DateException("Invalid day value: " + day);
		}
		return true;
	}
	
	/**
	 * Validates the month value.
	 * @param month The month to validate.
	 * @return true if the month is valid.
	 * @throws DateException if the month is invalid.
	 */
	public boolean monthValidation(int month) throws DateException {
		if (month < 1 || month > 12) {
			throw new DateException("Invalid month value: " + month);
		}
		return true;
	}
	
	/**
	 * Validates the year value.
	 * @param year The year to validate.
	 * @return true if the year is valid.
	 * @throws DateException if the year is invalid.
	 */
	public boolean yearValidation(int year) throws DateException {
		if(year < 0) {
			throw new DateException("Invalid year value: " + year);
		}
		return true;
	}

	/**
	 * Validates the day for a given month.
	 * @param day The day to validate.
	 * @param month The month associated with the day.
	 * @return true if the day is valid for the month.
	 * @throws DateException if the day is invalid for the month.
	 */
	public boolean dayAndMonthValidation(int day, int month) throws DateException {
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12:
				if (day < 1 || day > 31) {
					throw new DateException("Invalid day for month " + month + ": " + day);
				}
				break;
			case 4, 6, 9, 11:
				if (day < 1 || day > 30) {
					throw new DateException("Invalid day for month " + month + ": " + day);
				}
				break;
			case 2:
				if (day < 1 || day > 28) {
					throw new DateException("Invalid day for month " + month + ": " + day);
				}
				break;
			default:
				throw new DateException("Invalid month: " + month);
		}
		return true;
	}

	/**
	 * Validates the day, month, and year combination.
	 * @param day The day to validate.
	 * @param month The month to validate.
	 * @param year The year to validate.
	 * @return true if the date is valid.
	 * @throws DateException if the date is invalid.
	 */
	public boolean dayMonthYearValidation(int day, int month, int year) throws DateException {
	    if (year < 1) {
	        throw new DateException("Invalid year: " + year);
	    }
	    
	    if (month < 1 || month > 12) {
	        throw new DateException("Invalid month: " + month);
	    }

	    switch (month) {
	        case 1, 3, 5, 7, 8, 10, 12: 
	            if (day < 1 || day > 31) {
	                throw new DateException("Invalid day for month " + month + ": " + day);
	            }
	            break;
	        case 4, 6, 9, 11: 
	            if (day < 1 || day > 30) {
	                throw new DateException("Invalid day for month " + month + ": " + day);
	            }
	            break;
	        case 2: 
	            boolean leapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	            if (leapYear) {
	                if (day < 1 || day > 29) {
	                    throw new DateException("Invalid day for February in leap year " + year + ": " + day);
	                }
	            } else {
	                if (day < 1 || day > 28) {
	                    throw new DateException("Invalid day for February in non-leap year " + year + ": " + day);
	                }
	            }
	            break;
	    }
	    
	    return true;
	}
	
	/**
     * Validates a date provided as a string.
     *
     * @param dateString The date string to validate.
     * @return true if the date string is valid, false otherwise.
     */
    public boolean validateDateString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            @SuppressWarnings("unused")
			Date date = dateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}