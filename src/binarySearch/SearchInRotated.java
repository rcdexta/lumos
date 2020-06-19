package binarySearch;

public class SearchInRotated {

    public int search(int[] nums, int target) {
        // find pivot element
        int pivotIndex = findPivotIndex(nums);

        // adjust problem space according to pivot element
        int left = 0, right = nums.length - 1;
        if (target >= nums[pivotIndex] && target <= nums[nums.length - 1]) {
            left = pivotIndex;
        } else {
            right = pivotIndex;
        }

        // then its a regular binary search ahoy!
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int findPivotIndex(int [] nums) {
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

        return 0;
    }
}
