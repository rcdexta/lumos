package arrays;

public class OddSortedPair {

    /**
     * Given a sorted array, find the only two unsorted elements and sort them inline
     */

    public int[] swap(int[] arr) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (start == -1) {
                    start = i;
                    end = i + 1;
                } else {
                    end = i + 1;
                    break;
                }
            }
        }
        if (start != -1) swap(arr, start, end);
        return arr;
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
