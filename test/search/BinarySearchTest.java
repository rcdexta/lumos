package search;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search() {
        assertTrue(BinarySearch.search(asList(2,4,7,19,23), 7));
        assertTrue(BinarySearch.search(asList(9, 12, 17, 19), 12));
        assertFalse(BinarySearch.search(asList(9, 12, 17, 19), 1));
        assertTrue(BinarySearch.search(asList(9, 12, 17, 19), 9));
        assertTrue(BinarySearch.search(asList(9, 12, 17, 19), 19));
    }
}