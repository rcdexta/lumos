package common;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertUtils {

    public static void _assertEquals(int [] actual, int[] expected) {
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void _assertEquals(Integer [] actual, Integer[] expected) {
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }
}
