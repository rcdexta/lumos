package ds.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircularQueueTest {

    CircularQueue queue = new CircularQueue(4);

    @BeforeEach
    void setUp() {
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);
    }

    @Test
    void enqueue() {
        assertEquals(4, queue.peek());
        queue.enqueue(15);
        assertEquals(6, queue.peek());
        queue.enqueue(2);
        assertEquals(8, queue.peek());
    }

    @Test
    void dequeue() throws QueueEmptyException {
        assertEquals(4, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(10, queue.dequeue());
    }

    @Test
    void addCircular() throws QueueEmptyException {
        assertEquals(4, queue.size());
        queue.enqueue(16);
        assertEquals(4, queue.size());
        assertEquals(6, queue.peek());
        queue.enqueue(14);
        assertEquals(8, queue.dequeue());
        assertEquals(10, queue.dequeue());
        assertEquals(16, queue.dequeue());
        assertEquals(14, queue.dequeue());
    }
}