package bst;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BSTKClosestTest {

    @Test
    void closestKValues() {
        BSTClosest.TreeNode treeNode1 = new BSTClosest.TreeNode(1);
        BSTClosest.TreeNode treeNode3 = new BSTClosest.TreeNode(3);
        BSTClosest.TreeNode treeNode2 = new BSTClosest.TreeNode(2, treeNode1, treeNode3);
        BSTClosest.TreeNode treeNode5 = new BSTClosest.TreeNode(5);
        BSTClosest.TreeNode treeNode4 = new BSTClosest.TreeNode(4, treeNode2, treeNode5);

        BSTKClosest bstkClosest = new BSTKClosest();
        assertEquals(asList(4, 3), bstkClosest.closestKValues(treeNode4, 3.71, 2));
        assertEquals(asList(4, 3, 5), bstkClosest.closestKValues(treeNode4, 3.71, 3));
        assertEquals(asList(5, 4), bstkClosest.closestKValues(treeNode4, 6, 2));

        assertEquals(asList(4, 3), bstkClosest.closestKValues(treeNode4, 3.71, 2));
        assertEquals(asList(4, 3, 5), bstkClosest.closestKValues(treeNode4, 3.71, 3));
        assertEquals(asList(5, 4), bstkClosest.closestKValues(treeNode4, 6, 2));

        BSTClosest.TreeNode tree2 = new BSTClosest.TreeNode(-7);
        BSTClosest.TreeNode tree3 = new BSTClosest.TreeNode(-2);
        BSTClosest.TreeNode tree1 = new BSTClosest.TreeNode(-5, tree2, tree3);
        assertEquals(asList(-7, -5), bstkClosest.closestKValues(tree1, -6.75, 2));
    }
}