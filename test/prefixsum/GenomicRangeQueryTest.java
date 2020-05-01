package prefixsum;

import common.AssertUtils;
import org.junit.jupiter.api.Test;

class GenomicRangeQueryTest {

    @Test
    void solution() {
        GenomicRangeQuery grq = new GenomicRangeQuery();

        AssertUtils._assertEquals(new int[]{2, 4, 1}, grq.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }
}