package misc;

import java.util.HashMap;
import java.util.Map;

class DLNode {
    int key, value;
    DLNode next, prev;

    public DLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public DLNode() {
    }
}

public class LRUCache {

    DLNode head, tail;
    Map<Integer, DLNode> map;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;

        head = new DLNode();
        tail = new DLNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            DLNode node = map.get(key);
            this.moveToFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!this.map.containsKey(key)) {
            if (map.size() == capacity) {
                DLNode lastNode = this.lastNode();
                this.removeNode(lastNode);
                map.remove(lastNode.key);
            }
            DLNode node = new DLNode(key, value);
            this.map.put(key, node);
            this.addNode(node);
        } else {
            DLNode node = this.map.get(key);
            node.value = value;
            this.moveToFirst(node);
        }
    }

    //  [P(head)|n1|N(n2)] ->  [P(n1)|n2|N]
    private void addNode(DLNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLNode node) {
        DLNode prev = node.prev;
        DLNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToFirst(DLNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLNode lastNode() {
        return this.tail.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */