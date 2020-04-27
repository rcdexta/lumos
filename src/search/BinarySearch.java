package search;

import java.util.List;

public class BinarySearch {

    // O(log n)
    public static Boolean search(List<Integer> elements, Integer element) {
        if (elements.isEmpty()) return false;

        int mid = elements.size() / 2;
        if (elements.get(mid).equals(element)) {
            return true;
        } else if (elements.get(mid) < element) {
            return search(elements.subList(mid+1, elements.size()), element);
        } else {
            return search(elements.subList(0, mid), element);
        }
    }
}
