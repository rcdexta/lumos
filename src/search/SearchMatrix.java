package search;

import static java.util.Arrays.asList;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int []firstElements = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firstElements[i] = matrix[i][0];
        }

        int possibleRow = binarySearchForRow(firstElements, target, 0, firstElements.length);
        System.out.println(possibleRow);
        return false;
    }

    public int binarySearchForRow(int[] array, int target, int start, int end) {
        int mid = (start + end) / 2;
        System.out.println(asList(start, end, mid));
        if (start > end) return -1;
        if (start == end) return start;
        if (target > array[mid]) {
            return binarySearchForRow(array, target, mid + 1, end);
        } else {
            return binarySearchForRow(array, target, start, mid - 1);
        }
    }

    public int binarySearch(int[] array, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) return -1;
        if (target == array[mid]) return mid;
        if (target > array[mid]) {
            return binarySearch(array, target, mid + 1, end);
        } else {
            return binarySearch(array, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        SearchMatrix sm = new SearchMatrix();
        sm.searchMatrix(matrix, 15);
    }
}

