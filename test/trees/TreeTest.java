package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    Tree tree;

    @BeforeEach
    void setUp() {
        tree = new Tree("root");
        tree.insertChild("child1");
        tree.insertChild("child2");
        tree.children.get(0).insertChild("child3");
        tree.children.get(0).insertChild("child4");
    }

    @Test
    void insertChild() {
        tree.insertChild("childx");
        assertEquals(3, tree.children.size());
    }

    @Test
    void contains() {
        assertTrue(tree.contains("child3"));
        assertFalse(tree.contains("childx"));
    }

    @Test
    void size() {
        assertEquals(5, tree.size());
    }

    @Test
    void removeChild() {
        assertEquals(5, tree.size());
        tree.removeChild("child3");
        assertFalse(tree.contains("child3"));
        assertEquals(4, tree.size());

        // remove child1 with all descendents
        tree.removeChild("child1");
        assertEquals(2, tree.size());
    }

    @Test
    void find() {
        Tree matchingNode = tree.find("child1");
        assertEquals("child1", matchingNode.value);
        assertEquals(2, matchingNode.children.size());
    }
}