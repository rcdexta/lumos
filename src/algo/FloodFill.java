package algo;

import java.util.Arrays;

public class FloodFill {

    public static void fill(int[][] matrix, int x, int y, int color) {
        fill(matrix, x, y, matrix[x][y], color);
    }

    public static void fill(int[][] matrix, int x, int y, int oldColor, int newColor) {
        if (matrix[x][y] != oldColor) return;

        matrix[x][y] = newColor;

        if (x - 1 >= 0) fill(matrix, x - 1, y, oldColor, newColor);
        if (x + 1 < matrix.length) fill(matrix, x + 1, y, oldColor, newColor);
        if (y - 1 >= 0) fill(matrix, x, y - 1, oldColor, newColor);
        if (y + 1 < matrix[x].length) fill(matrix, x, y + 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        fill(matrix, 4, 4, 3);

        for(int[] x: matrix)
            System.out.println(Arrays.toString(x));
        ;
    }
}
