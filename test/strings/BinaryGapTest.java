package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    @Test
    void find() {
        assertEquals(2, BinaryGap.find(9));
        assertEquals(4, BinaryGap.find(529));
        assertEquals(0, BinaryGap.find(15));
        assertEquals(5, BinaryGap.find(1041));
        assertEquals(25, BinaryGap.find(805306373));
        assertEquals(28, BinaryGap.find(1610612737));
        assertEquals(2, BinaryGap.find(328));
    }
}