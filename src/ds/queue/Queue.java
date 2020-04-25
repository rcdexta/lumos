package ds.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

    private List<T> queue = new ArrayList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.remove(0);
    }

    public Integer length() {
        return queue.size();
    }

    public Boolean isEmpty() {
        return queue.isEmpty();
    }

    public T peek() {
        return queue.get(0);
    }

    public T last() {
        return queue.get(queue.size() - 1);
    }
}
