package bst;

import bst.BSTClosest.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTKClosest {


    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = traverse(root);
        values.sort((i1, i2) -> i1.equals(i2) ? 0 : Math.abs(i1 - target) > Math.abs(i2 - target) ? 1 : -1);
        return values.subList(0, k);
    }

    private List<Integer> traverse(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.pop();
            values.add(node.val);
            if (node.left != null) queue.push(node.left);
            if (node.right != null) queue.push(node.right);
        }

        return values;
    }

}
