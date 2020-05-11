package bst;

import bst.BSTClosest.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTCountTest {

    @Test
    void countNodes() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, treeNode3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4, treeNode2, treeNode5);
        BSTCount bstCount = new BSTCount();
        assertEquals(5, bstCount.countNodes(treeNode4));
    }
}