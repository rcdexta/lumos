package misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    LRUCache lruCache;

    @BeforeEach
    void setUp() {
        lruCache = new LRUCache(2);
        lruCache.put(1, 100);
        lruCache.put(2, 200);
    }

    @Test
    void get() {
        assertEquals(100, lruCache.get(1));
        assertEquals(200, lruCache.get(2));
        assertEquals(-1, lruCache.get(3));
    }

    @Test
    void put() {
        lruCache.put(3, 300);
        assertEquals(300, lruCache.get(3));
    }

    @Test
    void lruBehavior() {
        lruCache.get(2);
        lruCache.put(3, 300);
        assertEquals(-1, lruCache.get(1));
        assertEquals(200, lruCache.get(2));
        assertEquals(300, lruCache.get(3));

        lruCache.get(2);
        lruCache.get(2);
        lruCache.get(2);
    }

}