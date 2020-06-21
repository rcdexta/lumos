package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    @Test
    void canJump() {
        JumpGame jp = new JumpGame();
        int[] steps1 = new int[]{2,3,1,1,4};
        assertTrue(jp.canJump(steps1));
//
        int[] steps2 = new int[]{2,5,0,0};
        assertTrue(jp.canJump(steps2));

        int[] steps3 = new int[]{3,2,1,0,4};
        assertFalse(jp.canJump(steps3));
    }

    @Test
    void canJumpOptimised() {
        JumpGame jp = new JumpGame();
        int[] steps1 = new int[]{2,3,1,1,4};
        assertTrue(jp.canJumpOptimised(steps1));

        int[] steps2 = new int[]{2,5,0,0};
        assertTrue(jp.canJumpOptimised(steps2));

        int[] steps3 = new int[]{3,2,1,0,4};
        assertFalse(jp.canJumpOptimised(steps3));
    }
}