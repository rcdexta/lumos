package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree("X");
        tree.insertChild("A");
        tree.insertChild("B");
        tree.insertChild("C");
        tree.insertChild("D");
        tree.insertChild("E");
        tree.insertChild("F");
    }

    @Test
    void shouldInsertInLevelOrder() {
        assertEquals("X", tree.value);
        assertEquals("A", tree.left.value);
        assertEquals("B", tree.right.value);
        assertEquals("C", tree.left.left.value);
        assertEquals("D", tree.left.right.value);
        assertEquals("E", tree.right.left.value);
        assertEquals("F", tree.right.right.value);
    }

    @Test
    void contains() {
        assertTrue(tree.contains("A"));
        assertFalse(tree.contains("Y"));
    }

    @Test
    void size() {
        assertEquals(7, tree.size());
    }

    @Test
    void inorderTraversal() {
        List<String> tracker = new ArrayList<>();
        tree.inOrderTraversal(tree -> tracker.add(tree.value));
        assertEquals(asList("C", "A", "D", "X", "E", "B", "F"), tracker);
    }

    @Test
    void preorderTraversal() {
        List<String> tracker = new ArrayList<>();
        tree.preOrderTraversal(tree -> tracker.add(tree.value));
        assertEquals(asList("X", "A", "C", "D", "B", "E", "F"), tracker);
    }

    @Test
    void postorderTraversal() {
        List<String> tracker = new ArrayList<>();
        tree.postOrderTraversal(tree -> tracker.add(tree.value));
        assertEquals(asList("C", "D", "A", "E", "F", "B", "X"), tracker);
    }

    @Test
    void levelorderTraversal() {
        List<String> tracker = new ArrayList<>();
        tree.levelOrderTraversal(tree -> tracker.add(tree.value));
        assertEquals(asList("X", "A", "B", "C", "D", "E", "F"), tracker);
    }

}