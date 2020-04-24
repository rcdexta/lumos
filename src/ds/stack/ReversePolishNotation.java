package ds.stack;

public class ReversePolishNotation {

    public static class InvalidExpression extends Throwable {}

    public static Integer solve(String expression) throws InvalidExpression {
        Stack<Integer> operands = new Stack<>();

        String[] tokens = expression.split(",");
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

    public static Integer applyOperator(Integer operand1, Integer operand2, String operator) {
        switch(operator) {
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
