package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapacityPlannerTest {

    @Test
    void shouldSolve() {
        int[] w = new int[]{3,6,7,11};
        int d = 8;

        CapacityPlanner cp = new CapacityPlanner();
        assertEquals(4, cp.minEatingSpeed(w, d));

    }
}