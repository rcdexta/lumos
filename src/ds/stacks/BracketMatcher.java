package ds.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 */
public class BracketMatcher {

    //O(N)
    public int solution(String S) {
        // odd numbered strings will not match
        if (S.length() % 2 != 0) return 0;

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchingBracket = new HashMap<>();
        matchingBracket.put(']', '[');
        matchingBracket.put(')', '(');
        matchingBracket.put('}', '{');

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                //opening bracket and corresponding closing brackets should match
                Character openingBracket = matchingBracket.get(c);
                if (stack.peek() == openingBracket) {
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
