package arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeSumTest {

    @Test
    void threeSum() {
        ThreeSum subject = new ThreeSum();
        List<List<Integer>> lists = subject.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}