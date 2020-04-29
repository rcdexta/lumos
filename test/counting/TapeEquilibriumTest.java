package counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapeEquilibriumTest {

    @Test
    void findMinSum() {
        TapeEquilibrium s = new TapeEquilibrium();
        assertEquals(1, s.solution(new int[]{3, 1, 2, 4, 3}));
        assertEquals(4, s.solution(new int[]{4}));
        assertEquals(0, s.solution(new int[]{}));
        assertEquals(2000, s.solution(new int[]{-1000, 1000}));
        assertEquals(0, s.solution(new int[]{-2, -3, -4, -1}));
    }
}