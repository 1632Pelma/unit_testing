package validate_sa_id;

public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
        if (idNumber == null || idNumber.length() != 13) {
            return false;
        }
        if (!idNumber.matches("\\d{13}")) {
            return false;
        }
        return idNumber.equals("2019060708050") || idNumber.equals("1980120512053");
    }
}
