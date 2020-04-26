package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckTest {

    @Test
    void onePass() {
        assertTrue(PalindromeCheck.onePass("malayalam"));
        assertFalse(PalindromeCheck.onePass("malayala"));
        assertTrue(PalindromeCheck.onePass("repaper"));
    }
}