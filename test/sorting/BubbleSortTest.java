package sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

    @Test
    void BubbleSort() {
        List<Integer> sortedList = BubbleSort.sort(new ArrayList<>(asList(10, 5, 3, 8, 2, 6, 4, 7, 9, 1)));
        assertEquals(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), sortedList);

        List<Integer> sortedList2 = BubbleSort.sort(new ArrayList<>(asList(9,8,5,3,2)));
        assertEquals(asList(2, 3, 5, 8, 9), sortedList2);

        List<Integer> sortedList3 = BubbleSort.sort(new ArrayList<>(asList(5)));
        assertEquals(asList(5), sortedList3);
    }
}