package arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index,
 * and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
 *
 * For example, given
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        if (A.length == K) return A;
        for (int i = 1; i <= K; i++) {
            rotate(A);
        }
        return A;
    }

    private void rotate(int[] arr) {
        if (arr.length == 0) return;
        int temp = arr[arr.length - 1];
        for (int j = arr.length - 1; j > 0; j--) {
            arr[j] = arr[j-1];
        }
        arr[0] = temp;
    }
}
