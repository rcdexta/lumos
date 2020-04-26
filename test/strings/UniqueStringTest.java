package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueStringTest {

    @Test
    void checkIfStringHasUniqueCharacters() {
        assertTrue(UniqueString.check("abcde"));
        assertFalse(UniqueString.check("apple"));
    }
}