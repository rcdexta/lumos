package binarySearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinInRotated {

    public int findMin(int[] nums) {

        if (nums.length == 0) return -1;

        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // mid element is 11 here [7, 8, 10, 11, 2, 3, 4], then pivot is mid + 1
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // mid element is 2 here [7, 8, 10, 11, 2, 3, 4], then pivot is mid itself
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // if first element is greater than mid element [7, 8, 10, 11<here>, 2, 3, 4], then pivot is to the right
            // if first element is lesser than mid element [7, 8, 0, 1<here>, 2, 3, 4], then pivot is to the left
            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }
}
