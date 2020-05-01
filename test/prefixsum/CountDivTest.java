package prefixsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDivTest {

    @Test
    void solution() {
        CountDiv s = new CountDiv();
        assertEquals(3, s.solution(6, 11, 2));
        assertEquals(5, s.solution(5, 20, 3));
        assertEquals(4, s.solution(6, 12, 2));
        assertEquals(2, s.solution(11, 14, 2));
    }
}