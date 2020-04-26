package arrays;

import java.util.Collections;
import java.util.List;

/**
 * Given an unsorted array A of non-negative integers, find a continuous sub-array which adds to a given number sum.
 */
public class SubArraySum {

    public static List<Integer> solve(List<Integer> elements, int sum) {
        int i, j;

        for (i = 0; i < elements.size(); i++) {
            int expected = 0;
            for (j = i; j < elements.size(); j++) {
                expected += elements.get(j);
                if (expected >= sum) {
                    break;
                }
            }
            if (expected == sum) return elements.subList(i, j + 1);
        }

        return Collections.emptyList();
    }
}
