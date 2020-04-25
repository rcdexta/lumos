package ds.queue;

import ds.stack.MinStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class QueueTest {

    Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(19);
        queue.enqueue(4);
    }

    @Test
    void enqueue() {
        queue.enqueue(10);
        assertEquals(queue.length(), 7);
    }

    @Test
    void dequeue() {
        assertEquals(queue.dequeue(), 5);
    }

    @Test
    void length() {
        assertEquals(queue.length(), 6);
        queue.dequeue();
        assertEquals(queue.length(), 5);
    }

    @Test
    void isEmpty() {
        assertFalse(queue.isEmpty());
    }

    @Test
    void peek() {
        assertEquals(queue.peek(), 5);
        assertEquals(queue.peek(), 5);
    }
}