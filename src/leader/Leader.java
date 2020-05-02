package leader;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Read about concept of leader here: https://codility.com/media/train/6-Leader.pdf
 * <p>
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1
 * if array A does not have a dominator.
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 */
public class Leader {

    public int solution(int[] A) {
        if (A.length == 0) return -1;
        int[] original = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        int mid = A.length / 2;

        int possibleLeader = A[mid];
        int firstPos = -1;
        int count = 0;
        for(int i = 0; i < original.length; i++) {
            if (original[i] == possibleLeader) {
                count++;
                if (firstPos == -1) firstPos = i;
            }
        }

        return count > A.length / 2 ? firstPos : -1;
    }
}
