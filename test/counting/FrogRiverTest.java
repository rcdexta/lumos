package counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogRiverTest {

    @Test
    void shouldFindMaxTimeToCrossRiver() {
        int []A = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        assertEquals(6, new FrogRiver().solution(5, A));

        int []B = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        assertEquals(-1, new FrogRiver().solution(6, A));

        int []C = new int[]{1, 2, 3, 4};
        assertEquals(3, new FrogRiver().solution(4, C));
    }
}