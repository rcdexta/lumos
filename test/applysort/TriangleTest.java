package applysort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void solution() {
        Triangle t = new Triangle();
        assertEquals(1, t.solution(new int[]{10, 2, 5, 1, 8, 20}));
        assertEquals(1, t.solution(new int[]{Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2, Integer.MAX_VALUE}));
    }
}