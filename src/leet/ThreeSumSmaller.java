package leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumSmaller {

    public static int threeSum(int[] nums, int target) {
        Set<Integer> possibleThirds = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                int third = target - first - second;
                if (possibleThirds.contains(third)) {
                    System.out.printf("%s %s %s %n", first, second, third);
                }
            }
            possibleThirds.add(first);
        }

        return 0;
    }

    public static int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] < target) {
                    System.out.printf("%s %s %s %n", nums[i], nums[lo], nums[hi]);
                    result += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};

        int result = ThreeSumSmaller.threeSumSmaller(nums, 2);
        System.out.println(result);
    }
}
