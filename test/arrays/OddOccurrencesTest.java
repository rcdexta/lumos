package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddOccurrencesTest {

    @Test
    void solution() {
        OddOccurrences subject = new OddOccurrences();
        assertEquals(7, subject.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
        assertEquals(2, subject.solution(new int[]{1, 1, 1, 1, 2, 3, 3, 1, 1}));
        assertEquals(4, subject.solution(new int[]{4}));
        assertEquals(-1, subject.solution(new int[]{}));
    }
}