package applysort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductTripletTest {

    @Test
    void solution() {
        MaximumProductTriplet mpt = new MaximumProductTriplet();
        assertEquals(60, mpt.solution(new int[]{-3, 1, 2, -2, 5, 6}));
        assertEquals(32, mpt.solution(new int[]{4, 2, 4}));
        assertEquals(100, mpt.solution(new int[]{-5, -5, 4, 2}));
    }
}