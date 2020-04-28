package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotationCheckTest {

    @Test
    void validate() {
        assertTrue(RotationCheck.validate("waterbottle", "erbottlewat"));
        assertTrue(RotationCheck.validate("apple", "pleap"));
        assertTrue(RotationCheck.validate("camera", "meraca"));
        assertFalse(RotationCheck.validate("camera", "meracaa"));
    }
}