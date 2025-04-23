package validate_sa_id;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {
    @Test
    public void testValidIdNumbers() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"), "ID 2001014800086 should be valid");
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"), "ID 2909035800085 should be valid");
    }
}
