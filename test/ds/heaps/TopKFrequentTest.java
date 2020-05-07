package ds.heaps;

import common.AssertUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentTest {

    @Test
    void topKFrequent() {
        TopKFrequent tf = new TopKFrequent();
        AssertUtils._assertEquals(new int[]{1,2}, tf.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        AssertUtils._assertEquals(new int[]{1}, tf.topKFrequent(new int[]{1}, 1));
    }
}