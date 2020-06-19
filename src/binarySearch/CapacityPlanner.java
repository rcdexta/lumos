package binarySearch;

/**
 * Use binary search to find rate of consuming something
 */
public class CapacityPlanner {

    public int minEatingSpeed(int[] piles, int H) {
        int left = 0, right = 0;
        for(int p: piles) {
            right = Math.max(right, p);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.printf("%d %d %d %n", left, mid, right);
            if (canEatAll(piles, mid, H)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEatAll(int [] piles, int perHourRate, int H) {
        int hoursToEat = 0;

        for(int pile: piles) {
            hoursToEat += (pile / perHourRate);
            if (pile % perHourRate != 0) {
                hoursToEat++;
            }
        }

        System.out.println(hoursToEat);

        return hoursToEat <= H;
    }
}
