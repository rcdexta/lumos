package educative.trees;

import ds.trees.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdenticalTest {

    BinaryTree tree1;
    BinaryTree tree2;

    BinaryTree tree3;
    BinaryTree tree4;

    @BeforeEach
    void setUp() {
        tree1 = new BinaryTree("X");
        tree1.insertChild("A");
        tree1.insertChild("B");
        tree1.insertChild("C");
        tree1.insertChild("D");
        tree1.insertChild("E");
        tree1.insertChild("F");

        tree2 = new BinaryTree("X");
        tree2.insertChild("A");
        tree2.insertChild("B");
        tree2.insertChild("C");
        tree2.insertChild("D");
        tree2.insertChild("E");
        tree2.insertChild("F");

        tree3 = new BinaryTree("X");
        tree3.insertChild("A");
        tree3.insertChild("B");
        tree3.insertChild("C");
        tree3.insertChild("E");
        tree3.insertChild("F");

        tree4 = new BinaryTree("X");
        tree4.insertChild("A");
        tree4.insertChild("B");
        tree4.insertChild("C");
        tree4.insertChild("D");
        tree4.insertChild("E");
        tree4.insertChild("F");
    }

    @Test
    void areIdentical() {
        assertTrue(Identical.areIdentical(tree1, tree2));
        assertFalse(Identical.areIdentical(tree3, tree4));
    }
}