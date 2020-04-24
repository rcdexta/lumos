package ds.stack;

import ds.stack.ExpressionParser.InvalidExpression;
import org.junit.jupiter.api.Test;

import static ds.stack.ExpressionParser.solvePrefix;
import static org.junit.jupiter.api.Assertions.*;
import static ds.stack.ExpressionParser.solvePostfix;

class ExpressionParserTest {

    @Test
    void solvePostfixExpression() throws InvalidExpression {
        assertEquals(solvePostfix("3,4,+,2,*,1,+"), 15);
        assertEquals(solvePostfix("3,5,+,7,2,-,*"), 40);
    }

    @Test
    void flagInvalidExpression() throws InvalidExpression {
        assertThrows(InvalidExpression.class, () -> {
            solvePostfix("3,4,1,+");
        });
    }

    @Test
    void solvePrefixExpression() throws InvalidExpression {
        assertEquals(solvePrefix("+,1,*,2,+,3,4"), 15);
        assertEquals(solvePrefix("*,4,+,3,/,3,6"), 20);
    }
}