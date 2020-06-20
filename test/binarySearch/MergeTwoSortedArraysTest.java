package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedArraysTest {

    @Test
    void findMedianSortedArrays() {
        int[] num1 = new int[]{1, 3, 5, 7};
        int[] num2 = new int[]{2, 4, 6, 9, 10};

        MergeTwoSortedArrays mt = new MergeTwoSortedArrays();
//        assertEquals(5, mt.findMedianSortedArrays(num1, num2));


        num1 = new int[]{1, 2};
        num2 = new int[]{3, 4};

        assertEquals(2.5, mt.findMedianSortedArrays(num1, num2));
    }
}