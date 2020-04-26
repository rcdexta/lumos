package strings;

/**
 * Check if a string is a palindrome
 */
public class PalindromeCheck {

    // A palindrome has even number counts of characters or at most just one character with an odd count.
    // This means the string is either of even length or an odd length with just exactly one character with an odd count.
    // O(n + 128)
    public static boolean onePass(String s) {
        int[] charCounter = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCounter[(int) c]++;
        }

        int oddCount = 0;
        for (int counter : charCounter) {
            if (counter % 2 != 0) {
                if (oddCount == 0) {
                    oddCount++;
                } else return false;
            }
        }
        return true;
    }
}
