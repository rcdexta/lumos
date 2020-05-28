package arrays;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            Set<Integer> complements = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                int third = -first - second;
//                System.out.printf("(%s %s %s)%n", first, second, third);
                if (complements.contains(third)) {
//                    System.out.println("success");
                    results.add(Arrays.asList(first, second, third));
                }
                complements.add(nums[j]);
            }
        }


        return results;
    }
}
