package ds.stacks;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public T pop() throws StackEmptyException {
        if (items.isEmpty()) throw new StackEmptyException();
        return items.remove(currentIndex());
    }

    public void push(T item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public T peek() throws StackEmptyException {
        if (items.isEmpty()) throw new StackEmptyException();
        return items.get(currentIndex());
    }

    private int currentIndex() {
        return items.size() - 1;
    }

    public Integer length() {
        return items.size();
    }
}


