package ds.heaps;


import java.util.*;
import java.util.Map.Entry;

public class FrequentKWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordCounter = new HashMap<>();

        for (String word : words) {
            int count = wordCounter.getOrDefault(word, 0);
            wordCounter.put(word, count + 1);
        }

        PriorityQueue<Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) :
                b.getValue().compareTo(a.getValue()));

        maxHeap.addAll(wordCounter.entrySet());

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            list.add(maxHeap.poll().getKey());
        }
        return list;

    }

}
