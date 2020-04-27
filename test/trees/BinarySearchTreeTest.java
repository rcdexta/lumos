package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree tree;

    /**
     *                4
     *            2      6
     *         1    3  5   7
     */
    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree(4);
        tree.insertChild(2);
        tree.insertChild(1);
        tree.insertChild(3);
        tree.insertChild(6);
        tree.insertChild(5);
        tree.insertChild(7);
    }

    @Test
    void shouldInsertChild() {
        assertNull(tree.right);
        assertEquals(2, tree.left.value);
        assertEquals(1, tree.left.left.value);
        assertEquals(3, tree.left.right.value);
        assertEquals(6, tree.right.value);
        assertEquals(5, tree.right.left.value);
        assertEquals(7, tree.right.right.value);
        assertEquals(7, tree.size());
    }

    @Test
    void contains() {
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(19));
    }

    @Test
    void min() {
        assertEquals(1, tree.min());
    }

    @Test
    void max() {
        assertEquals(7, tree.max());
    }
}