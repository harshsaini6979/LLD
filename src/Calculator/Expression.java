package Calculator;

public class Expression implements ArithmaticExpression{
    private ArithmaticExpression left;
    private ArithmaticExpression right;
    private Operation operation;

    public Expression(ArithmaticExpression left, ArithmaticExpression right, Operation operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public double evaluate() {
        double result = 0;

        if (operation == Operation.ADD) {
            result = left.evaluate() + right.evaluate();
        } else if (operation == Operation.SUBTRACT) {
            result = left.evaluate() - right.evaluate();
        } else if (operation == Operation.MULTIPLY) {
            result = left.evaluate() * right.evaluate();
        } else if (operation == Operation.DIVIDE) {
            if (((Number) right).value != 0) {
                throw new ArithmeticException("Division by zero");
            }
            result = left.evaluate() / right.evaluate();
        }

        return result;
    }
}
