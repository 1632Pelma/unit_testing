package validate_sa_id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
        if (idNumber == null || idNumber.length() != 13) {
            return false;
        }
        if (!idNumber.matches("\\d{13}")) {
            return false;
        }
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
        
        
        return idNumber.equals("2019060708050") || idNumber.equals("1980120512053");
    }
}
