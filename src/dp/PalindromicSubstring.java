package dp;

public class PalindromicSubstring {

    static String bruteforce(String str) {
        int maxLength = 0;
        String palindrome = "";

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (isPalindrome(str, i, j)) {
                    int length = j - i;
                    if (maxLength < length) {
                        maxLength = length;
                        palindrome = str.substring(i, j + 1);
                    }
                }
            }
        }
        return palindrome;
    }

    static String dynamic(String str) {
        int n = str.length();

        int maxLength = 1;
        int start = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        printDP(dp, str);

        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                maxLength = 2;
                start = i;
                dp[i][i + 1] = true;
            }
        }

        printDP(dp, str);

        for (int k = 3; k <= n; k++) {
            System.out.printf("k=%d %n", k);
            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {

                // Get the ending index of substring from starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to jth index iff str.charAt(i+1) to str.charAt(j-1) is a palindrome
                if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }

            printDP(dp, str);
        }

        return str.substring(start, start + maxLength);
    }

    static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        String s1 = "abacab";
        String palindrome = dynamic(s1);
        System.out.println("Answer");
        System.out.println(palindrome);
    }

    static void printDP(boolean[][] dp, String str) {
        System.out.printf("%3c", ' ');
        for(int i=0;i<str.length();i++) {
            System.out.printf("%3c", str.charAt(i));
        }
        System.out.println("");

        for(int i=0;i<str.length();i++) {
            System.out.printf("%3c", str.charAt(i));
            for(int j=0;j<str.length();j++) {
                System.out.printf("%3c", dp[i][j] ? '1' : '0');
            }
            System.out.println();
        }

        System.out.println("-------");
    }
}
