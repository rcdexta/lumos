package applysort;

import java.util.Arrays;

public class Triangle {

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if ((long)A[i - 1] + (long)A[i - 2] > A[i]) {
                return 1;
            }
        }
        return 0;
    }
}
