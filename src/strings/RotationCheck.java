package strings;

/**
 * To check if a string is a rotation of another, concatenate original string twice and see if new string is substring of the concatenation!
 */
public class RotationCheck {

    //O(n)
    public static boolean validate(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        String s1Double = s1 + s1;
        return s1Double.contains(s2);
    }
}
