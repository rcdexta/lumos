package ds.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapSumTest {

    @Test
    void shouldCalculateSum() {
        MapSum ms = new MapSum();
        ms.insert("apple", 3);
        ms.insert("app", 2);
        assertEquals(5, ms.sum("app"));
    }

    @Test
    void shouldCalculateSumTweak() {
        MapSum ms = new MapSum();
        ms.insert("apple", 3);
        ms.insert("app", 2);
        assertEquals(5, ms.sum("ap"));
    }

    @Test
    void shouldCalculateSumAgain() {
        MapSum ms = new MapSum();
        ms.insert("house", 1);
        ms.insert("horizon", 2);
        ms.insert("horizontal", 3);
        ms.insert("home", 4);
        assertEquals(10, ms.sum("ho"));
    }
}