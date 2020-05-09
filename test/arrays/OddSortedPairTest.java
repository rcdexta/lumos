package arrays;

import common.AssertUtils;
import org.junit.jupiter.api.Test;

class OddSortedPairTest {

    @Test
    void sort() {
        OddSortedPair osp = new OddSortedPair();
        AssertUtils._assertEquals(new int[]{3, 5, 6, 7, 8, 9}, osp.sort(new int[]{3, 8, 6, 7, 5, 9}));
        AssertUtils._assertEquals(new int[]{3, 5, 6, 7, 8, 9}, osp.sort(new int[]{3, 5, 6, 9, 8, 7}));
        AssertUtils._assertEquals(new int[]{3, 5, 6, 7, 8, 9}, osp.sort(new int[]{3, 5, 7, 6, 8, 9}));
        AssertUtils._assertEquals(new int[]{}, osp.sort(new int[]{}));
        AssertUtils._assertEquals(new int[]{2}, osp.sort(new int[]{2}));
        AssertUtils._assertEquals(new int[]{1, 2}, osp.sort(new int[]{1, 2}));
        AssertUtils._assertEquals(new int[]{1, 2}, osp.sort(new int[]{2, 1}));
    }
}