package InterpreterDesignPattern;

public class NonTerminalExpression implements AbstractExpression {
    private AbstractExpression left;
    private AbstractExpression right;
    private String operator;

    public NonTerminalExpression(AbstractExpression left, AbstractExpression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public int interpret(Context context) {
        switch (operator) {
            case "+":
                return left.interpret(context) + right.interpret(context);
            case "-":
                return left.interpret(context) - right.interpret(context);
            case "*":
                return left.interpret(context) * right.interpret(context);
            case "/":
                return left.interpret(context) / right.interpret(context);
            default:
                throw new UnsupportedOperationException("Operator not supported: " + operator);
        }
    }
}
