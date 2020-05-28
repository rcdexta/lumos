package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array A of non-negative integers, find a continuous sub-array which adds to zero.
 *
 * [6, 4, -7, 3, 12, 9]
 * [6, 10, 3, 6, 18, 27]
 */


public class SubArrayZero {

    public boolean solve(int[] elements) {
        Set<Integer> sumTracker = new HashSet<>();

        int sum = 0;
        for (int element : elements) {
            sum += element;

            if (sum == 0 || sumTracker.contains(sum)) return true;

            sumTracker.add(sum);
        }

        return false;
    }
}
