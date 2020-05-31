package arrays;

class Pair {
    public Integer r;
    public Integer c;

    public Pair(Integer r, Integer c) {
        this.r = r;
        this.c = c;
    }
}

public class SortedMatrix {

    static Pair translateLinearIndex(int matrix[][], int idx) {
        int colLength = matrix[0].length;

        int r = idx / colLength;
        int c = idx % colLength;

        return new Pair(r, c);
    }

    static int elementAt(int matrix[][], int idx) {
        Pair pair = translateLinearIndex(matrix, idx);
        return matrix[pair.r][pair.c];
    }


    public static Pair searchInMatrix(int matrix[][], int value) {

        int start  = 0;
        int end = (matrix.length * matrix[0].length) - 1;

        Pair pair = new Pair(-1, -1);

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int el = elementAt(matrix, mid);


            if (el == value) pair = translateLinearIndex(matrix, mid);

            if (value < el) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return pair;
    }

}
