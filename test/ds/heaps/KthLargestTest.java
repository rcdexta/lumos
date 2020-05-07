package ds.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestTest {

    @Test
    void findKthLargest() {
        KthLargest k = new KthLargest();

        assertEquals(5, k.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        assertEquals(4, k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}