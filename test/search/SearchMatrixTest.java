package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchMatrixTest {

    @Test
    void searchMatrix() {
        SearchMatrix sm = new SearchMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        assertTrue(sm.searchMatrix(matrix, 3));
//        assertFalse(sm.searchMatrix(matrix, 13));
    }
}