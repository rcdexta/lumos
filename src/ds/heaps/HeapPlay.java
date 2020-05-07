package ds.heaps;

import java.util.PriorityQueue;

public class HeapPlay {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(40);
        pq.add(3);
        pq.add(19);
        System.out.println(pq.toString());
        pq.add(2);
        System.out.println(pq.toString());
        pq.add(19);
        System.out.println(pq.toString());

        pq.add(-1);
        System.out.println(pq.toString());

    }
}
