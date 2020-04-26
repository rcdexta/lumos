package strings;

/**
 * Check if two strings are one edit away: insert a character, remove a character or replace a character
 */
public class OneAway {

    // For strings of same length, check for one difference
    public static boolean checkForUpdates(String s1, String s2) {
        int numOfChanges = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (numOfChanges == 0) numOfChanges++;
                else return false;
            }
        }
        return true;
    }

    // For strings of different length, use shorter string as baseline and check for one difference
    private static boolean checkForAdditionDeletion(String s1, String s2) {
        String shorterString = s1.length() < s2.length() ? s1 : s2;
        String longerString = s1.length() > s2.length() ? s1 : s2;
        int numOfChanges = 0;
        for (int i = 0, j = 0; i < shorterString.length() && j < longerString.length(); ) {
            if (shorterString.charAt(i) != longerString.charAt(j)) {
                if (numOfChanges == 0) numOfChanges++;
                else return false;
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

    // O(n)
    public static boolean check(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        if (s1.length() == s2.length()) {
            return checkForUpdates(s1, s2);
        } else {
            return checkForAdditionDeletion(s1, s2);
        }
    }

}
