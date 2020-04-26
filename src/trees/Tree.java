package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class Tree {

    String value;
    List<Tree> children;

    public Tree(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void insertChild(String value) {
        this.children.add(new Tree(value));
    }

    public void removeChild(String valueToRemove) {
        Iterator<Tree> childIterator = this.children.iterator();
        while (childIterator.hasNext()) {
            Tree child = childIterator.next();
            if (child.value.equals(valueToRemove)) {
                childIterator.remove();
            } else {
                child.removeChild(valueToRemove);
            }
        }
    }

    public static void traverse(Tree tree, Consumer<Tree> callback) {
        callback.accept(tree);
        for (Tree child : tree.children) {
            Tree.traverse(child, callback);
        }
    }

    public Integer size() {
        AtomicInteger size = new AtomicInteger(0);
        Tree.traverse(this, tree -> size.set(size.get() + 1));
        return size.get();
    }

    public boolean contains(String searchValue) {
        AtomicBoolean found = new AtomicBoolean(false);
        Tree.traverse(this, tree -> {
            if (tree.value.equals(searchValue)) found.set(true);
        });
        return found.get();
    }

    public Tree find(String valueToFind) {
        AtomicReference<Tree> matchingNode = new AtomicReference<>();
        Tree.traverse(this, tree -> {
            if (tree.value.equals(valueToFind)) matchingNode.set(tree);
        });
        return matchingNode.get();
    }
}
