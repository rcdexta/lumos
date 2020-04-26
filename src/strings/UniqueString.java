package strings;

/**
 * Check if a string has unique character
 */
public class UniqueString {

    // O(n)
    public static boolean check(String str) {
        boolean[] mask = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (mask[(int) c]) return false;
            mask[(int) c] = true;
        }
        return true;
    }
}
