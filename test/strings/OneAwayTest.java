package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneAwayTest {

    @Test
    void check() {
        assertTrue(OneAway.check("pale", "bale"));
        assertFalse(OneAway.check("pale", "bake"));
        assertTrue(OneAway.check("pale", "ple"));
        assertTrue(OneAway.check("pales", "pale"));
    }
}