package counting;

/**
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 */
public class PermMissingElem {
    //O(n)
    public int solution(int[] A) {
        long n = A.length + 1;
        long arraySum = 0;
        for (int value : A) {
            arraySum += value;
        }
        long expectedSum = n * (n+1) / 2;
        return (int)(expectedSum - arraySum);
    }
}
