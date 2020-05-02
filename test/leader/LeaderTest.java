package leader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeaderTest {

    @Test
    void solution() {
        Leader l = new Leader();
        assertEquals(0, l.solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        assertEquals(-1, l.solution(new int[]{}));
        assertEquals(0, l.solution(new int[]{2, 3, 2}));
        assertEquals(0, l.solution(new int[]{4, 4, 4, 3, 3, 3, 4}));
        assertEquals(2, l.solution(new int[]{0, 0, 1, 1, 1}));
        assertEquals(-1, l.solution(new int[]{0, 0, 0, 1, 1, 1}));
        assertEquals(-1, l.solution(new int[]{1, 0, 1, 0, 1, 0}));
        assertEquals(0, l.solution(new int[]{1, 2, 1}));
        assertEquals(-1, l.solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
        assertEquals(-1, l.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2}));
    }
}