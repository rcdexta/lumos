package ds.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BracketMatcherTest {

    @Test
    void solution() {
        BracketMatcher bm = new BracketMatcher();
        assertEquals(1, bm.solution("[]"));
        assertEquals(1, bm.solution("{[()()]}"));
        assertEquals(1, bm.solution("[{}]"));
        assertEquals(1, bm.solution("[{()()}]"));
        assertEquals(1, bm.solution(""));
        assertEquals(1, bm.solution("[[[[]]]]"));
        assertEquals(0, bm.solution("[{()()]"));
        assertEquals(0, bm.solution("([)()]"));
        assertEquals(1, bm.solution("{[()()]}{[()()]}"));

        assertEquals(1, bm.solution("(()(())())"));
        assertEquals(0, bm.solution("())"));
    }
}