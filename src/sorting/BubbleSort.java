package sorting;

import java.util.List;

public class BubbleSort {

    // O(n^2)
    public static List<Integer> sort(List<Integer> nums) {
        // Bubble sort works by comparing two adjacent numbers next to each other and then
        // swapping their places if the smaller index's value is larger than the larger
        // index's. Continue looping through until all values are in ascending order
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) > nums.get(i + 1)) {
                    int temp = nums.get(i);
                    nums.set(i, nums.get(i + 1));
                    nums.set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);
        return nums;
    }
}
