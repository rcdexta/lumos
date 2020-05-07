package ds.heaps;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> entries = new HashMap<>();
        for (int n : nums) {
            int count = entries.getOrDefault(n, 0);
            entries.put(n, count + 1);
        }
        PriorityQueue<Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue().compareTo(a.getValue()));
        maxHeap.addAll(entries.entrySet());

        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            results.add(maxHeap.poll().getKey());
        }
        return results.stream().mapToInt(i->i).toArray();
    }
}
