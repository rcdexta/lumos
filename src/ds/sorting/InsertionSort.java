package ds.sorting;

import java.util.List;

public class InsertionSort {

    // O(n^2)
    public static List<Integer> sort(List<Integer> elements) {
        // The idea here is that the beginning of your list is sorted and the everything else is assumed to be an unsorted mess.
        // The outer loop goes over the whole list, the index of which signifies where the "sorted" part of the list is. The inner
        // loop goes over the sorted part of the list and inserts it into the correct position in the array.
        for (int i = 1; i < elements.size(); i++) {
            for(int j = 0; j < i; j++)
                if (elements.get(j) > elements.get(i)) {
                    int temp = elements.get(i);
                    elements.set(i, elements.get(j));
                    elements.set(j, temp);
                }
        }
        return elements;
    }
}
