package strings;

/**
 * Implement basic string compression using the counts of repeated characters (RLE)
 */
public class Compression {

    // O(n)
    public static String perform(String s) {
        StringBuilder compressed = new StringBuilder(s.length() / 2);
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            counter++;
            if (i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                compressed.append(s.charAt(i));
                compressed.append(counter);
                counter = 0;
            }
        }

        return compressed.toString();
    }
}
