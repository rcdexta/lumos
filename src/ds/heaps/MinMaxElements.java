package ds.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMaxElements {

    public Integer[] findMinK(Integer[] numbers, Integer k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (Integer num : numbers) {
            maxHeap.add(num);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        return maxHeap.toArray(new Integer[0]);
    }


    public Integer[] findMaxK(Integer[] numbers, Integer k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer num : numbers) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.toArray(new Integer[0]);
    }


}
