package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a big list of dates in 20’s, how to efficiently sort the list.
 * Example:
 *
 * Input:
 *        Date arr[] = {{20,  1, 2014},
 *                     {25,  3, 2010},
 *                     { 3, 12, 2000},
 *                     {18, 11, 2001},
 *                     {19,  4, 2015},
 *                     { 9,  7, 2005}}
 *
 * Output:
 *       Date arr[] = {{ 3, 12, 2000},
 *                     {18, 11, 2001},
 *                     { 9,  7, 2005},
 *                     {25,  3, 2010},
 *                     {20,  1, 2014},
 *                     {19,  4, 2015}}
 */
public class SortDates {

    public void sort(int[][] dates) {
        List<Integer> fullDates = new ArrayList<>();
        for (int[] date : dates) {
            int d = date[2] * 10000 + date[1] * 100 + date[0];
            fullDates.add(d);
        }
        Collections.sort(fullDates);
    }

    public static void main(String[] args) {
        int[][] dates = new int[][]{{20, 1, 2014}, {25, 3, 2010}, {3, 12, 2000}};
        new SortDates().sort(dates);
    }
}
