package strings;

/**
 * Find largest binary gap of 0s between two 1s
 */
public class BinaryGap {

    //O(n)
    public static int find(Integer n) {
        String binary = Integer.toBinaryString(n);
        int maxGap = 0;
        int oneIndex = -1;

        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '1' && oneIndex == -1) oneIndex = i;
            else if (c == '1') {
                maxGap = Math.max(maxGap, i - oneIndex - 1);
                oneIndex = i;
            }
        }
        return maxGap;
    }
}
