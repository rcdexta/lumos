package shopping;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class OfferOptimizer {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int maxPrice = findPrice(price, needs);

        for (List<Integer> offer : special) {
            if (!offerExceedsNeeds(offer, needs)) {
                int offerPrice = offer.get(offer.size() - 1);
                int excessPrice = getExcessPrice(price, needs, offer);
                maxPrice = Math.min(offerPrice + excessPrice, maxPrice);
            }
        }

        return maxPrice;
    }

    private void getMaxOfferMultiplier(List<Integer> offer, List<Integer> needs) {
        List<Integer> cart = new ArrayList<>();
        while (true) {
            for (int i = 0; i < needs.size(); i++) {
                int current = cart.get(i);
                if (current + offer.get(i) < needs.get(i)) {

                }
            }
        }
    }

    private int getExcessPrice(List<Integer> price, List<Integer> needs, List<Integer> offer) {
        return range(0, needs.size()).map(i -> {
                        int outOfOfferQtyNeeded = needs.get(i) - offer.get(i);
                        return outOfOfferQtyNeeded * price.get(i);
                    }).sum();
    }

    private int findPrice(List<Integer> price, List<Integer> needs) {
        return range(0, needs.size()).map(i -> price.get(i) * needs.get(i)).sum();
    }

    private boolean offerExceedsNeeds(List<Integer> offer, List<Integer> needs) {
        return range(0, needs.size()).anyMatch(i -> offer.get(i) > needs.get(i));
    }
}
