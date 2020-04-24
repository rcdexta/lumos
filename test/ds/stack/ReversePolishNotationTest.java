package ds.stack;

import ds.stack.ReversePolishNotation.InvalidExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ds.stack.ReversePolishNotation.solve;

class ReversePolishNotationTest {

    @Test
    void shouldResolveExpression() throws InvalidExpression {
        assertEquals(solve("3,4,+,2,*,1,+"), 15);
        assertEquals(solve("3,5,+,7,2,-,*"), 40);
    }

    @Test
    void shouldThrowExceptionIfExpressionInvalid() throws InvalidExpression {
        assertThrows(InvalidExpression.class, () -> {
            solve("3,4,1,+");
        });
    }
}