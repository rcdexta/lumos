package applysort;

import java.util.Arrays;

public class MaximumProductTriplet {
    public int solution(int[] A) {
        Arrays.sort(A);
        int last = A.length - 1;
        int prod1 = A[last] * A[last - 1] * A[last - 2];
        int prod2 = A[0] * A[1] * A[last];
        return Math.max(prod1, prod2);
    }
}
