package ds.heaps;

import java.util.*;

public class MergeSortedArrays {

    public List<Integer> merge(List<List<Integer>> arrays) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        List<Iterator<Integer>> iterators = new ArrayList<>();
        for (List<Integer> array: arrays) {
            iterators.add(array.iterator());
        }

        boolean hasMoreElements = false;
        for(int i=0; ; i = (i + 1) % arrays.size()) {

            if (iterators.get(i).hasNext()) {
                Integer element = iterators.get(i).next();
                minHeap.add(element);
                if (minHeap.size() > 3) result.add(minHeap.poll());
                hasMoreElements = true;
            }

            if (i == arrays.size() - 1) {
                if (!hasMoreElements) break;
                hasMoreElements = false;
            }
        }

        while(!minHeap.isEmpty()) result.add(minHeap.poll());

        return result;
    }
}
