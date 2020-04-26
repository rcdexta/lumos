package ds.queues;

public class CircularQueue {

    Integer[] queue;
    Integer head, tail;

    public CircularQueue(Integer length) {
        queue = new Integer[length];
        head = 0;
        tail = -1;
    }

    public void enqueue(Integer item) {
        moveTail();
        queue[tail] = item;
        if (head.equals(tail)) {
            moveHead();
        }
    }

    public Integer dequeue() throws QueueEmptyException {
        Integer item = peek();
        moveHead();
        return item;
    }

    public Integer peek() {
        return queue[head];
    }

    public Integer size() {
        return tail >= head ? tail - head + 1 : queue.length - head - tail + 1;
    }

    private void moveTail(){
        tail = (tail + 1) % queue.length;
        if (tail.equals(head)) moveHead();
    }

    private void moveHead() {
        head = (head + 1) % queue.length;
    }


}
