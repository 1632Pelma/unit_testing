package validate_sa_id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
        // Validate that ID number contains 13 digits
        if (idNumber == null || idNumber.length() != 13) {
            return false;
        }
        if (!idNumber.matches("\\d{13}")) {
            return false;
        }
        
        // Validate date entered and ensures no future date is chosen
        String datePart = idNumber.substring(0, 6);
        try {
            String yearPrefix = Integer.parseInt(datePart.substring(0, 2)) > 24 ? "19" : "20";
            LocalDate date = LocalDate.parse(yearPrefix + datePart, DateTimeFormatter.ofPattern("yyyyMMdd"));
            if (date.isAfter(LocalDate.now())) {
                return false;
            }
        } catch (DateTimeParseException e) {
            return false;
        }
        
        // Validate Gender
        int genderCode = Integer.parseInt(idNumber.substring(6, 10));
if (genderCode < 0 || genderCode > 9999) {
    return false;
}

// Validate citizenship (C)
char citizenship = idNumber.charAt(10);
if (citizenship != '0' && citizenship != '1') {
    return false;
}

// Validate fixed digit (A)
char fixedDigit = idNumber.charAt(11);
if (fixedDigit != '8') {
    return false;
}

// Validate checksum (Z) using Luhn algorithm
int sum = 0;
boolean alternate = false;
for (int i = 12; i >= 0; i--) {
    int n = Character.getNumericValue(idNumber.charAt(i));
    if (alternate) {
        n *= 2;
        if (n > 9) {
            n = (n % 10) + 1;
        }
    }
    sum += n;
    alternate = !alternate;
}
if (sum % 10 != 0) {
    return false;
}
      
        return true;
    }
}
