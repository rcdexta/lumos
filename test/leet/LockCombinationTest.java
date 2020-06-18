package leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LockCombinationTest {

    @Test
    void openLock() {
        LockCombination lc = new LockCombination();
        assertEquals(6, lc.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        assertEquals(1, lc.openLock(new String[]{"8888"}, "0009"));
        assertEquals(-1, lc.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }
}