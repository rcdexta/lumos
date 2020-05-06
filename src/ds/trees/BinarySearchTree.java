package ds.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * A binary search tree has only two children and all descendants to left are lesser than the node and all descendants to right are greater
 */
public class BinarySearchTree {

    Integer value;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(Integer value) {
        this.value = value;
    }

    public void insertChild(Integer value) {
        if (this.value > value) {
            if (this.left == null) this.left = new BinarySearchTree(value);
            else this.left.insertChild(value);
        } else {
            if (this.right == null) this.right = new BinarySearchTree(value);
            else this.right.insertChild(value);
        }
    }

    public Integer size() {
        AtomicInteger size = new AtomicInteger(0);
        this.levelOrderTraversal(tree -> size.set(size.get() + 1));
        return size.get();
    }

    public boolean contains(Integer match) {
        if (this.value.equals(match)) return true;

        if (this.value > match && this.left != null) {
            return this.left.contains(match);
        }

        if (this.value < match && this.right != null) {
            return this.right.contains(match);
        }

        return false;
    }

    public void levelOrderTraversal(Consumer<BinarySearchTree> callback) {
        callback.accept(this);

        Deque<BinarySearchTree> queue = new ArrayDeque<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            BinarySearchTree currentTree = queue.removeFirst();

            if (currentTree.left != null) {
                callback.accept(currentTree.left);
                queue.add(currentTree.left);
            }

            if (currentTree.right != null) {
                callback.accept(currentTree.right);
                queue.add(currentTree.right);
            }
        }
    }

    public int min() {
        if(this.left != null) {
            return this.left.min();
        }
        return this.value;
    }

    public int max() {
        if(this.right != null) {
            return this.right.max();
        }
        return this.value;
    }
}
