package counting;

public class TapeEquilibrium {

    public int solution(int[] A) {
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];

        long totalSum = 0;
        for (int value : A) {
            totalSum += value;
        }

        long minSum = Long.MAX_VALUE;
        long runningsum = 0;
        for (int i = 0; i < A.length -1; i++) {
            runningsum += A[i];
            long rest = totalSum - runningsum;
            minSum = Math.min(minSum, Math.abs(runningsum - rest));
        }

        return (int)minSum;
    }

}
