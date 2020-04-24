package ds.stack;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class ExpressionParser {

    public static class InvalidExpression extends Throwable {}

    // Also called Reverse Polish Notation
    public static Integer solvePostfix(String expression) throws InvalidExpression {
        String[] tokens = expression.split(",");
        return solveAsPostFix(tokens);
    }


    // Also called Polish Notation
    public static Integer solvePrefix(String expression) throws InvalidExpression {
        String[] tokens = expression.split(",");
        List<String> tokensList = asList(tokens);
        Collections.reverse(tokensList);
        return solveAsPostFix(tokensList.toArray(new String[tokens.length]));
    }

    private static Integer solveAsPostFix(String[] tokens) throws InvalidExpression {
        Stack<Integer> operands = new Stack<>();
        try {
            for (String token : tokens) {
                switch (token) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        Integer result = applyOperator(operands.pop(), operands.pop(), token);
                        operands.push(result);
                        break;
                    default:
                        operands.push(Integer.parseInt(token));
                }
            }
            if (operands.length() > 1) throw new InvalidExpression();
            return operands.pop();
        } catch (StackEmptyException e) {
            throw new InvalidExpression();
        }
    }

    private static Integer applyOperator(Integer operand1, Integer operand2, String operator) {
        switch (operator) {
            case "+":
                return operand2 + operand1;
            case "-":
                return operand2 - operand1;
            case "*":
                return operand2 * operand1;
            case "/":
                return operand2 / operand1;
        }
        return 0;
    }
}
