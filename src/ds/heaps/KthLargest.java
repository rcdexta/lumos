package ds.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        for (int x:nums) {
            maxHeap.add(x);
        }
        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }
        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }
}
