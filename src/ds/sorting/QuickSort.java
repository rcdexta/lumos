package ds.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    // O(n*logn)
    public static List<Integer> sort(List<Integer> elements) {
        if (elements.size() < 2) return elements;

        //[1] Assume the last element as the pivot element
        Integer pivot = elements.remove(elements.size() - 1);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        //[2] Segregate elements lesser and greater than pivot in separate arrays
        for (int element : elements) {
            if (element < pivot) {
                left.add(element);
            } else {
                right.add(element);
            }
        }

//        System.out.println("Left: " + left.toString());
//        System.out.println("Pivot: " + pivot);
//        System.out.println("Right: " + right.toString());
//        System.out.println("---");

        //[3] Recursively call the sort on left and right arrays.
        //[4] Finally merge the left + pivot + right as one array
        List<Integer> results = new ArrayList<>(sort(left));
        results.add(pivot);
        results.addAll(sort(right));

        return results;
    }
}
