package applysort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistinctTest {

    @Test
    void solution() {
        Distinct s = new Distinct();
        assertEquals(3, s.solution(new int[]{2, 1, 1, 2, 3, 1}));
    }

}