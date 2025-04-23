package validate_sa_id;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {
    @Test
    public void testValidIdNumbers() {
        assertTrue(ValidateSaId.isIdNumberValid("2019060708050"), "ID 2019060708050 should be valid");
        assertTrue(ValidateSaId.isIdNumberValid("1980120512053"), "ID 1980120512053 should be valid");
    }
    
    @Test
public void testInvalidLength() {
    assertFalse(ValidateSaId.isIdNumberValid("020525030612"), "ID with 12 digits should be invalid");
    assertFalse(ValidateSaId.isIdNumberValid("02052503061225"), "ID with 14 digits should be invalid");
    assertFalse(ValidateSaId.isIdNumberValid(""), "Empty ID should be invalid");
}

@Test
public void testNonNumeric() {
    assertFalse(ValidateSaId.isIdNumberValid("200101480008a"), "ID with letters should be invalid");
    assertFalse(ValidateSaId.isIdNumberValid("200101480008@"), "ID with symbols should be invalid");
}
@Test
public void testInvalidDate() {
    assertFalse(ValidateSaId.isIdNumberValid("9913314800080"), "Invalid month 13 should fail");
    assertFalse(ValidateSaId.isIdNumberValid("9902324800086"), "Invalid day 32 should fail");
    assertFalse(ValidateSaId.isIdNumberValid("0000004800086"), "Invalid date 000000 should fail");
}

}
