package counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermCheckTest {

    @Test
    void solution() {
        assertEquals(1, new PermCheck().solution(new int[]{4, 1, 3, 2}));
        assertEquals(0, new PermCheck().solution(new int[]{4, 1, 3}));
        assertEquals(0, new PermCheck().solution(new int[]{1, 4, 1}));
        assertEquals(0, new PermCheck().solution(new int[]{1, 1}));
    }
}