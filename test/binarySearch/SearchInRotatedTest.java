package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedTest {

    @Test
    void search() {
        SearchInRotated s = new SearchInRotated();
        assertEquals(4, s.search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, s.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}