package bst;

import java.util.Deque;

public class BSTClosest {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public int closestValue(TreeNode root, double target) {
        return traverseFind(root, target, Math.abs(root.val - target), root.val);
    }

    private int traverseFind(TreeNode root, double target, double minDiff, int closest) {
        if (root == null) return closest;
        double diff = Math.abs(root.val - target);
        if (minDiff > diff) {
            minDiff = diff;
            closest = root.val;
        }
        if (root.val > target) {
            return traverseFind(root.left, target, minDiff, closest);
        } else {
            return traverseFind(root.right, target, minDiff, closest);
        }
    }
}
