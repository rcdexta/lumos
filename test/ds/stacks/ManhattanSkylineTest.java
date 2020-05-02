package ds.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanSkylineTest {

    @Test
    void solution() {
        ManhattanSkyline ms = new ManhattanSkyline();
        assertEquals(7, ms.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }
}