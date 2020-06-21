package ds.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixTest {

    @Test
    void shouldConvert() throws StackEmptyException {
        String infix = "(1+(4+5)*3)/6";
        String postfix = "145+3*+6/";



        assertEquals(postfix, InfixToPostfix.convert(infix));
    }

}