package shopping;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferOptimizerTest {

    @Test
    void shoppingOffers() {
        OfferOptimizer offerOptimizer = new OfferOptimizer();
        assertEquals(14, offerOptimizer.shoppingOffers(asList(2, 5), asList(asList(3, 0, 5), asList(1, 2, 10)), asList(3, 2)));
        assertEquals(11, offerOptimizer.shoppingOffers(asList(2, 3, 4), asList(asList(1, 1, 0, 4), asList(2, 2, 1, 9)), asList(1, 2, 1)));
        assertEquals(2, offerOptimizer.shoppingOffers(asList(9, 1), Collections.singletonList(asList(1, 1, 1)), asList(2, 2)));
    }
}