package ds.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {

    @Test
    void mergeSort() {
        List<Integer> sortedList = MergeSort.mergeSort(new ArrayList<>(asList(10, 5, 3, 8, 2, 6, 4, 7, 9, 1)));
        assertEquals(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), sortedList);

        List<Integer> sortedList2 = MergeSort.mergeSort(new ArrayList<>(asList(9,8,5,3,2)));
        assertEquals(asList(2, 3, 5, 8, 9), sortedList2);
    }
}