package validation;

import exception.HourException;

/**
 * The HourValidation class provides methods for validating time components.
 * This class includes methods to validate hours and minutes in both 24-hour and 12-hour formats.
 *
 * @version 1.0
 * @since 2024-05-20
 * @author Aarón Rojas
 */
public class HourValidation {

    /**
     * Validates the hour and minute in 24-hour format.
     *
     * @param hour the hour to validate (0-23)
     * @param min the minute to validate (0-59)
     * @return true if the time is valid, false otherwise
     * @throws HourException if the hour or minute is out of range
     */
    public boolean IntHourValidation(int hour, int min) throws HourException {
        if (hour < 0 || hour > 24 || min < 0 || min > 59) {
            throw new HourException("The hour " + hour + ":" + min + " is wrong");
        }
        return true;
    }

    /**
     * Validates the hour and minute in 12-hour format.
     *
     * @param hour the hour to validate (1-12)
     * @param minute the minute to validate (0-59)
     * @param isPM true if the time is PM, false if AM
     * @return true if the time is valid, false otherwise
     * @throws HourException if the hour or minute is out of range
     */
    public boolean isValid12HourFormat(int hour, int minute, boolean isPM) throws HourException {
        if (hour < 1 || hour > 12 || minute < 0 || minute > 59) {
            throw new HourException("The hour " + hour + ":" + minute + " " + (isPM ? "PM" : "AM") + " is wrong");
        }
        return true;
    }

    /**
     * Validates a time string in the format HH:MM AM/PM.
     *
     * @param time the time string to validate
     * @return true if the time string is valid, false otherwise
     * @throws HourException if the time string is not in a valid format
     */
    public boolean isValidTimeString12Hours(String time) throws HourException {
        if (time == null || !time.matches("^(1[0-2]|0?[1-9]):([0-5][0-9]) ?([APap][mM])$")) {
            throw new HourException("The time string " + time + " is in the wrong format");
        }

        // Split the time into its components
        String[] parts = time.split("[: ]");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        boolean isPM = parts[2].equalsIgnoreCase("PM");

        return isValid12HourFormat(hour, minute, isPM);
    }

    /**
     * Validates a time string in the format HH:MM (24-hour format).
     *
     * @param time the time string to validate
     * @return true if the time string is valid, false otherwise
     * @throws HourException if the time string is not in a valid format
     */
    public boolean isValidTimeString(String time) throws HourException {
        if (time == null || !time.matches("^([01]?[0-9]|2[0-3]):([0-5][0-9])$")) {
            throw new HourException("The time string " + time + " is in the wrong format");
        }

        // Split the time into its components
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return IntHourValidation(hour, minute);
    }
}