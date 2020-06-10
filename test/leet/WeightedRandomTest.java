package leet;

import org.junit.jupiter.api.Test;

class WeightedRandomTest {

    @Test
    void pickIndex() {
        WeightedRandom wr = new WeightedRandom(new int[]{9, 1, 2});
        for(int i=1;i<=20;i++) {
            System.out.println(wr.pickIndex());
        }

    }
}