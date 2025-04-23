package validate_sa_id;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {
    @Test
    public void testValidIdNumbers() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"), "ID 2001014800086 should be valid");
    assertTrue(ValidateSaId.isIdNumberValid("2909035800085"), "ID 2909035800085 should be valid");
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
@Test
public void testGender() {
    assertTrue(ValidateSaId.isIdNumberValid("2001014800086"), "Female ID (4800) should be valid");
    assertTrue(ValidateSaId.isIdNumberValid("2001015800084"), "Male ID (5800) should be valid");
    assertFalse(ValidateSaId.isIdNumberValid("2001019999086"), "Invalid gender (9999) needs valid checksum");
}

@Test
public void testCitizenshipAndFixedDigit() {
    assertTrue(ValidateSaId.isIdNumberValid("2001014800086"), "Citizen (0) should be valid");
    assertTrue(ValidateSaId.isIdNumberValid("2001014800184"), "Permanent resident (1) should be valid");
    assertFalse(ValidateSaId.isIdNumberValid("2001014800026"), "Invalid citizenship (2) should fail");
    assertFalse(ValidateSaId.isIdNumberValid("2001014800096"), "Invalid fixed digit (9) should fail");
}

@Test
public void testChecksum() {
    assertTrue(ValidateSaId.isIdNumberValid("2001014800086"), "Valid checksum should pass");
    assertFalse(ValidateSaId.isIdNumberValid("2001014800085"), "Invalid checksum should fail");
}
}
