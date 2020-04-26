package arrays;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class SubArraySumTest {

    @Test
    void solve() {
        assertEquals(asList(2,3,7), SubArraySum.solve(asList(1,2,3,7,5), 12));
        assertEquals(asList(1,2,3,4,5), SubArraySum.solve(asList(1,2,3,4,5,6,7,8,9,10), 15));
        assertEquals(Collections.emptyList(), SubArraySum.solve(asList(1,2,3,4,5,6,7,8,9,10), 100));
    }
}