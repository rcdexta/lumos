package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinInRotatedTest {

    @Test
    void findMin() {
        MinInRotated m = new MinInRotated();
        assertEquals(1, m.findMin(new int[]{3, 4, 5, 1, 2}));
        assertEquals(0, m.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}