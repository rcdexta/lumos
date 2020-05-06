package ds.heaps;

import common.AssertUtils;
import org.junit.jupiter.api.Test;

class MinMaxElementsTest {

    @Test
    void findMinimumElements() {
        MinMaxElements mk = new MinMaxElements();
        AssertUtils._assertEquals(new Integer[]{4, 3, 2}, mk.findMinK(new Integer[]{9, 10, 7, 4, 6, 3, 8, 2}, 3));
    }

    @Test
    void findMaximumElements() {
        MinMaxElements mk = new MinMaxElements();
        AssertUtils._assertEquals(new Integer[]{8, 10, 9}, mk.findMaxK(new Integer[]{9, 10, 7, 4, 6, 3, 8, 2}, 3));
    }
}