package counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogJumpTest {

    @Test
    void solution() {
        assertEquals(3, new FrogJump().solution(10, 85, 30));
        assertEquals(3, new FrogJump().solution(10, 100, 30));
        assertEquals(4, new FrogJump().solution(10, 101, 30));
        assertEquals(5, new FrogJump().solution(1, 10, 2));
    }
}