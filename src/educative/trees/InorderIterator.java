package educative.trees;

import ds.trees.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InorderIterator {
    Queue<BinaryTree> queue;
    
    public InorderIterator(BinaryTree root) {
        queue = new ArrayDeque<>();
        queue.add(root.left);
        queue.add(root);
        queue.add(root.right);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public BinaryTree getNext() {
        BinaryTree node = queue.poll();
        return node;
    }

    //Don't Change anything down below
    public String inorderUsingIterator(BinaryTree root) {
        InorderIterator iter = new InorderIterator(root);
        String result = "";
        while (iter.hasNext()) {
            result += iter.getNext().value + " ";
        }
        return result;
    }
}