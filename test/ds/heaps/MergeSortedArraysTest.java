package ds.heaps;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortedArraysTest {

    @Test
    void merge() {
        MergeSortedArrays msa = new MergeSortedArrays();

        List<Integer> l1 = asList(3, 5, 7);
        List<Integer> l2 = asList(0, 6);
        List<Integer> l3 = asList(0, 6, 28);
        assertEquals(asList(0, 0, 3, 5, 6, 6, 7, 28), msa.merge(asList(l1, l2, l3)));


        List<Integer> l4 = asList(19, 21);
        List<Integer> l5 = asList(1, 3);
        List<Integer> l6 = asList(4, 6);
        List<Integer> l7 = asList(2, 5, 20);
        assertEquals(asList(1, 2, 3, 4, 5, 6, 19, 20, 21), msa.merge(asList(l4, l5, l6, l7)));
    }
}