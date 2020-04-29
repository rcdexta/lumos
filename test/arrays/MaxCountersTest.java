package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static common.AssertUtils._assertEquals;

class MaxCountersTest {

    MaxCounters s;

    @BeforeEach
    void setUp() {
        s = new MaxCounters();
    }

    @Test
    void solution() {
        int[] solution = s.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        _assertEquals(new int[]{3, 2, 2, 4, 2}, solution);

        int[] solution1 = s.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4, 6});
        _assertEquals(new int[]{4, 4, 4, 4, 4}, solution1);

        int[] solution2 = s.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4, 6, 3});
        _assertEquals(new int[]{4, 4, 5, 4, 4}, solution2);
    }
}