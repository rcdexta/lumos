package arrays;

import org.junit.jupiter.api.Test;

class SortedMatrixTest {

    int[][] matrix = {{2, 4, 5, 7},
            {9, 12, 15, 19},
            {21, 23, 26, 27},
            {28, 31, 32, 38}};

    @Test
    void searchInMatrix() {
        Pair pair = SortedMatrix.searchInMatrix(matrix, 27);
        assertEquals(2, pair.r);
        assertEquals(3, pair.c);

        pair = SortedMatrix.searchInMatrix(matrix, 21);
        assertEquals(2, pair.r);
        assertEquals(0, pair.c);

        pair = SortedMatrix.searchInMatrix(matrix, 2);
        assertEquals(0, pair.r);
        assertEquals(0, pair.c);
    }

    @Test
    void shouldTranslateLinearIndextoRowCol() {
        Pair pair = SortedMatrix.translateLinearIndex(matrix, 1);
        assertEquals(0, pair.r);
        assertEquals(1, pair.c);

        pair = SortedMatrix.translateLinearIndex(matrix, 10);
        assertEquals(2, pair.r);
        assertEquals(1, pair.c);
    }

    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            String message = String.format("Assertion failed: Expected: %s | Actual: %s", expected, actual);
            throw new AssertionError(message);
        }
    }


}