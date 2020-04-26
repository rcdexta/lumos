package ds.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static List<Integer> mergeSort(List<Integer> elements) {
        if (elements.size() < 2) {
            return elements;
        }
        int mid = elements.size() / 2;
        List<Integer> array1 = elements.subList(0, mid);
        List<Integer> array2 = elements.subList(mid, elements.size());

        //[1] Split the given array at mid point and recursively merge by sorting
        return merge(mergeSort(array1), mergeSort(array2));
    }

    private static List<Integer> merge(List<Integer> array1, List<Integer> array2) {
        List<Integer> results = new ArrayList<>();

        int i = 0, j = 0;

        //[2] Collect the smallest elements in both arrays first
        while(true) {
            if (array1.get(i) < array2.get(j)) {
                results.add(array1.get(i));
                i++;
            } else {
                results.add(array2.get(j));
                j++;
            }
            if (i == array1.size() || j == array2.size()) {
                break;
            }
        }

        //[3] Collect residual elements from both arrays
        if (i < array1.size()) {
            results.addAll(array1.subList(i, array1.size()));
        }

        if (j < array2.size()) {
            results.addAll(array2.subList(j, array2.size()));
        }

        return results;
    }
}
