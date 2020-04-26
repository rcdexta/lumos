package strings;

import java.util.Arrays;

/**
 * Check if two strings are permutations of one another
 */
public class PermutationCheck {

    // Check for length and then sorting each string and comparing
    // O(2*n*logn)
    public static boolean checkBySorting(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        String s1Sorted = sort(s1);
        String s2Sorted = sort(s2);

        return s1Sorted.equals(s2Sorted);
    }


    // Check for length and then use a mask to check if same characters occur in both string
    // O(2n)
    public static boolean checkInline(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int [] charCounter = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            charCounter[(int)c]++;
        }

        for (int j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);
            charCounter[(int)c]--;
        }

        for (int c : charCounter) {
            if (c != 0) return false;
        }

        return true;
    }

    private static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
