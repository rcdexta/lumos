package arrays;

/**
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 */
public class MaxCounters {

    //O(n)
    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int[] c = new int[-1];

        int currentMax = -1;
        int allMax = -1;

        for (int value: A) {
            if (value <= N) {
                int pos = value - 1;
                if (counter[pos] < allMax) counter[pos] = allMax;
                counter[pos] += 1;
                currentMax = Math.max(currentMax, counter[pos]);
            } else {
                // cache currentMax to offset other numbers later
                allMax = currentMax;
            }
        }

        // equalize all positions to allMax
        for (int i = 0; i < counter.length; i++) {
            counter[i] = Math.max(counter[i], allMax);
        }

        return counter;
    }
}
