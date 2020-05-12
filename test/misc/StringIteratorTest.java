package misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringIteratorTest {

    @Test
    void shouldIterate() {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        assertEquals('L', iterator.next());
        assertEquals('e', iterator.next());
        assertEquals('e', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals('t', iterator.next());
        assertEquals('C', iterator.next());
        assertEquals('o', iterator.next());
        assertEquals('d', iterator.next());
        assertEquals('e', iterator.next());
        assertFalse(iterator.hasNext());

        iterator = new StringIterator("a10");
        assertTrue(iterator.hasNext());
        assertEquals('a', iterator.next());
        assertEquals('a', iterator.next());
        assertEquals('a', iterator.next());
        assertEquals('a', iterator.next());
        assertEquals('a', iterator.next());
        assertEquals('a', iterator.next());
        assertEquals('a', iterator.next());
        assertEquals('a', iterator.next());

        iterator = new StringIterator("");
        assertFalse(iterator.hasNext());

        iterator = new StringIterator("x6");
        assertTrue(iterator.hasNext());
        assertEquals('x', iterator.next());
        assertEquals('x', iterator.next());
        assertEquals('x', iterator.next());
        assertEquals('x', iterator.next());
        assertEquals('x', iterator.next());
        assertEquals('x', iterator.next());
        assertEquals(' ', iterator.next());
        assertFalse(iterator.hasNext());
    }
}