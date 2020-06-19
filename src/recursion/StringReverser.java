package recursion;

import java.util.Stack;

public class StringReverser {

    public static void main(String[] args) {
        Stack stack = new Stack();

        String rev = reverse("abcdefg");
        System.out.println(rev);

        String unique = removeDuplicate("Thiss iiss aa teesstt");
        System.out.println(unique);

        String one = "ace";
        String two = "bfx";
        String answer = alphabeticMerge(one, two);
        System.out.println(answer);
    }

    private static String reverse(String str) {
        if (str.length() == 0) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    private static String removeDuplicate(String str) {
        if (str.length() == 1) return str;
        if (str.charAt(0) == str.charAt(1)) {
            return removeDuplicate(str.substring(1));
        }
        return str.charAt(0) + removeDuplicate(str.substring(1));
    }

    private static String alphabeticMerge(String one, String two) {
        if (one.length() == 0 && two.length() > 0) return two;
        if (two.length() == 0 && one.length() > 0) return one;
        if (one.length() == 0) return "";
        if (one.charAt(0) < two.charAt(0)) {
            return one.charAt(0) + alphabeticMerge(one.substring(1), two);
        } else {
            return two.charAt(0) + alphabeticMerge(one, two.substring(1));
        }
    }
}
