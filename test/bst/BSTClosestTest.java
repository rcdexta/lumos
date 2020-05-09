package bst;

import bst.BSTClosest.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTClosestTest {

    @Test
    void closestValue() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, treeNode3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4, treeNode2, treeNode5);

        BSTClosest bstClosest = new BSTClosest();
        assertEquals(4, bstClosest.closestValue(treeNode4, 3.75));
        assertEquals(5, bstClosest.closestValue(treeNode4, 6));
        assertEquals(1, bstClosest.closestValue(treeNode4, 1));
        assertEquals(3, bstClosest.closestValue(treeNode4, 2.75));
        assertEquals(2, bstClosest.closestValue(treeNode4, 2.25));
    }
}