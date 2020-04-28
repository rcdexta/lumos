package arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CyclicRotationTest {

    @Test
    void solution() {
        assertEquals(Arrays.toString(new int[]{6, 3, 8, 9, 7}), Arrays.toString(new CyclicRotation().solution(new int[]{3, 8, 9, 7, 6}, 1)));
        assertEquals(Arrays.toString(new int[]{9, 7, 6, 3, 8}), Arrays.toString(new CyclicRotation().solution(new int[]{3, 8, 9, 7, 6}, 3)));
        assertEquals(Arrays.toString(new int[]{}), Arrays.toString(new CyclicRotation().solution(new int[]{}, 3)));
        assertEquals(Arrays.toString(new int[]{1, 2, 3}), Arrays.toString(new CyclicRotation().solution(new int[]{1, 2, 3}, 0)));
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4}), Arrays.toString(new CyclicRotation().solution(new int[]{1, 2, 3, 4}, 4)));
    }
}