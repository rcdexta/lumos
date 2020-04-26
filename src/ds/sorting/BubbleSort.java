package ds.sorting;

import java.util.List;

public class BubbleSort {

    // O(n^2)
    public static List<Integer> sort(List<Integer> elements) {
        // Bubble sort works by comparing two adjacent numbers next to each other and then
        // swapping their places if the smaller index's value is larger than the larger
        // index's. Continue looping through until all values are in ascending order
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < elements.size() - 1; i++) {
                if (elements.get(i) > elements.get(i + 1)) {
                    int temp = elements.get(i);
                    elements.set(i, elements.get(i + 1));
                    elements.set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);
        return elements;
    }
}
