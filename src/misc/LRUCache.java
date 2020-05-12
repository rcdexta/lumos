package misc;

import java.util.*;

public class LRUCache {

    int capacity;
    Map<Integer, Integer> cache;
    LinkedList<Integer> tracker;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        tracker = new LinkedList<>();
    }

    public int get(int key) {
        Integer value = cache.getOrDefault(key, -1);
        if (value != -1) moveToFront(key);
        return value;
    }

    private void moveToFront(Integer num) {
        tracker.remove(num); // You can track the index of the number in the same hashmap instead of doing a scan
        tracker.addFirst(num);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            moveToFront(key);
        } else {
            if (tracker.size() == capacity) {
                Integer leastUsedNumber = tracker.removeLast();
                cache.remove(leastUsedNumber);
            }
            tracker.addFirst(key);
        }
        cache.put(key, value);
    }
}
