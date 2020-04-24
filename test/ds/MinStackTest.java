package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MinStackTest {

    MinStack stack;

    @BeforeEach
    void setUp() {
        stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(1);
        stack.push(1);
    }

    @Test
    void pop() throws StackEmptyException {
        assertEquals(stack.pop(), 1);
    }

    @Test
    void push() throws StackEmptyException {
        stack.push(10);
        assertEquals(stack.length(), 6);
        assertEquals(stack.peek(), 10);
    }

    @Test
    void isEmpty() {
        assertFalse(stack.isEmpty());
    }

    @Test
    void peek() throws StackEmptyException {
        assertEquals(stack.peek(), 1);
    }

    @Test
    void min() throws StackEmptyException {
        assertEquals(stack.min(), 1);
        stack.pop();
        assertEquals(stack.min(), 1);
        stack.pop();
        stack.pop();
        assertEquals(stack.min(), 2);
        stack.pop();
        assertEquals(stack.min(), 5);
    }
}