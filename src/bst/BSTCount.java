package bst;

import bst.BSTClosest.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTCount {

    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) return count;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        while(!queue.isEmpty()) {
            count++;
            TreeNode node = queue.pop();
            if (node.left != null) queue.push(node.left);
            if (node.right != null) queue.push(node.right);
        }

        return count;
    }

}
