package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationCheckTest {

    @Test
    void checkBySorting() {
        assertTrue(PermutationCheck.checkBySorting("carrot", "tarroc"));
        assertFalse(PermutationCheck.checkBySorting("hello", "llloh"));
    }

    @Test
    void checkInline() {
        assertTrue(PermutationCheck.checkInline("carrot", "tarroc"));
        assertFalse(PermutationCheck.checkInline("hello", "llloh"));
        assertFalse(PermutationCheck.checkInline("madam", "adama"));
        assertTrue(PermutationCheck.checkInline("apple", "papel"));
    }
}