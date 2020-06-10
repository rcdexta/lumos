package leet;

import java.util.Arrays;

public class WeightedRandom {

    int [] prefixSum;
    int totalSum;

    public WeightedRandom(int[] w) {
        prefixSum = new int[w.length];
        int totalSum = 0;
        for(int i=0;i<w.length;i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
        this.totalSum = totalSum;
        System.out.println(Arrays.toString(prefixSum));
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        System.out.println(target);

        int left = 0, right = this.prefixSum.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefixSum[mid] == target) return mid;

            if (target < prefixSum[mid]) right = mid;
                    else left = mid + 1;
        }
        return left;
    }

}
