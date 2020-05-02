package ds.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FishUpstreamDownstreamTest {

    @Test
    void solution() {
        FishUpstreamDownstream f = new FishUpstreamDownstream();
        int[]A = new int[]{4, 3, 2, 1, 5};
        int[]B = new int[]{0, 1, 0, 0, 0};
        assertEquals(2, f.solution(A, B));
    }
}