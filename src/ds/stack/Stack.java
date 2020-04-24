package ds.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public T pop() throws StackEmptyException {
        if (elements.isEmpty()) throw new StackEmptyException();
        return elements.remove(currentIndex());
    }

    public void push(T newElement) {
        elements.add(newElement);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public T peek() throws StackEmptyException {
        if (elements.isEmpty()) throw new StackEmptyException();
        return elements.get(currentIndex());
    }

    private int currentIndex() {
        return elements.size() - 1;
    }

    public Integer length() {
        return elements.size();
    }
}
