package prefixsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassingCarsTest {

    @Test
    void solution() {
        PassingCars p = new PassingCars();
        assertEquals(5, p.solution(new int[]{0, 1, 0, 1, 1}));
        assertEquals(8, p.solution(new int[]{0, 1, 0, 1, 1, 0, 1}));
    }
}