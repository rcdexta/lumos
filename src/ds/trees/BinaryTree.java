package ds.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * A binary tree has only two children
 *
 *              1
 *         2      3
 *      4    5  6   7
 * Depth First Traversals:
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 6 3 7
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3 6 7
 * (c) Postorder (Left, Right, Root) : 4 5 2 6 7 3 1
 *
 * Breadth First or Level Order Traversal : 1 2 3 4 5 6 7
 */
public class BinaryTree {

    String value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(String value) {
        this.value = value;
    }

    public BinaryTree insertChild(String value) {
        BinaryTree child = new BinaryTree(value);

        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.add(this);
        boolean inserted = false;

        while (!queue.isEmpty() && !inserted) {
            BinaryTree currentTree = queue.removeFirst();

            if (currentTree.left == null) {
                currentTree.left = child;
                inserted = true;
            } else if (currentTree.right == null) {
                currentTree.right = child;
                inserted = true;
            } else {
                queue.add(currentTree.left);
                queue.add(currentTree.right);
            }
        }
        return child;
    }

    public Integer size() {
        AtomicInteger size = new AtomicInteger(0);
        this.levelOrderTraversal(tree -> size.set(size.get() + 1));
        return size.get();
    }

    public void inOrderTraversal(Consumer<BinaryTree> callback) {
        if (this.left != null) {
            this.left.inOrderTraversal(callback);
        }

        callback.accept(this);

        if (this.right != null) {
            this.right.inOrderTraversal(callback);
        }
    }

    public void preOrderTraversal(Consumer<BinaryTree> callback) {
        callback.accept(this);

        if (this.left != null) {
            this.left.preOrderTraversal(callback);
        }

        if (this.right != null) {
            this.right.preOrderTraversal(callback);
        }
    }

    public void postOrderTraversal(Consumer<BinaryTree> callback) {
        if (this.left != null) {
            this.left.postOrderTraversal(callback);
        }

        if (this.right != null) {
            this.right.postOrderTraversal(callback);
        }

        callback.accept(this);
    }


    public void levelOrderTraversal(Consumer<BinaryTree> callback) {
        callback.accept(this);

        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            BinaryTree currentTree = queue.removeFirst();

            if (currentTree.left != null ){
                callback.accept(currentTree.left);
                queue.add(currentTree.left);
            }

            if (currentTree.right != null) {
                callback.accept(currentTree.right);
                queue.add(currentTree.right);
            }
        }
    }

    public boolean contains(String searchValue) {
        AtomicBoolean found = new AtomicBoolean(false);
        this.levelOrderTraversal(tree -> {
            if (tree.value.equals(searchValue)) found.set(true);
        });
        return found.get();    }
}
