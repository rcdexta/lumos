package applysort;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 */
public class Distinct {

    //O(N)
    public int solution(int[] A) {
        Map<Integer, Boolean> distinct = new HashMap<>();
        int distinctCount = 0;
        for (int value : A) {
            if (!distinct.containsKey(value)) {
                distinctCount++;
                distinct.put(value, true);
            }
        }
        return distinctCount;
    }

    public int oneDistinct(int [] nums) {
        int x = nums[0];
        for(int i=1;i<nums.length;i++) {
            x = x ^ nums[i];
            System.out.println(x);
        }
        return x;
    }
}
