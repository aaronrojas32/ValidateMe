package validation;

import exception.DNIException;

public class DNIValidation {
    
    /**
     * Validates a Spanish DNI (Documento Nacional de Identidad).
     * 
     * @param dni The DNI to validate.
     * @return true if the DNI is valid, false otherwise.
     * @throws DNIException If the format of the DNI is incorrect.
     */
    public static boolean isValidDNI(String dni) throws DNIException {
        // Check if the DNI has the correct format (8 digits followed by a letter)
        if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new DNIException("Invalid DNI format");
        }
        
        // Extract the numerical part of the DNI
        String numbers = dni.substring(0, 8);
        
        // Extract the letter part of the DNI
        String letter = dni.substring(8).toUpperCase();
        
        // Calculate the expected letter based on the numerical part
        String expectedLetter = calculateLetter(numbers);
        
        // Check if the calculated letter matches the provided letter
        return letter.equals(expectedLetter);
    }
    
    /**
     * Calculates the letter associated with a numerical part of a Spanish DNI.
     * 
     * @param numbers The numerical part of the DNI (8 digits).
     * @return The letter associated with the DNI.
     */
    private static String calculateLetter(String numbers) {
        String[] letters = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int remainder = Integer.parseInt(numbers) % 23;
        return letters[remainder];
    }
}
