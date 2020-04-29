package counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingIntegerTest {

    @Test
    void solution() {
        MissingInteger s = new MissingInteger();
        assertEquals(5, s.solution(new int[]{1, 3, 6, 4, 1, 2}));
        assertEquals(1, s.solution(new int[]{-1, -4, 0}));
        assertEquals(4, s.solution(new int[]{1, 2, 3}));
        assertEquals(1, s.solution(new int[]{4, 2, 3, 9, 10, 3, 1000000}));
    }
}