package counting;

import java.util.HashMap;
import java.util.Map;

/**
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing.
 */
public class PermCheck {
    //O(n)
    public int solution(int[] A) {
        Map<Integer, Boolean> tracker = new HashMap<>();
        long n = A.length;
        long arraySum = 0;
        for (int value : A) {
            if (tracker.containsKey(value)) return 0;
            arraySum += value;
            tracker.put(value, true);
        }
        long expectedSum = n * (n+1) / 2;
        return expectedSum == arraySum ? 1 : 0;
    }
}
