package misc;

import java.util.*;

public class LRUCache {

    int capacity;
    Map<Integer, Integer> cache;
    LinkedList<Integer> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        queue = new LinkedList<>();
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            evictElement(key);
        } else if (queue.size() == capacity){
            Integer lastElement = queue.removeLast();
            cache.remove(lastElement);
        }
        cache.put(key, value);
        queue.addFirst(key);
    }

    public Integer get(int key) {
        if (cache.containsKey(key)) {
            evictElement(key);
            queue.addFirst(key);
            return cache.get(key);
        } else {
            return null;
        }
    }

    private void evictElement(int element) {
        int index = 0, i = 0;
        for (Integer next : queue) {
            if (next == element) {
                index = i;
                break;
            }
            i++;
        }
        queue.remove(index);
    }
}
