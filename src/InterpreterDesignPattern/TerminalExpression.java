package InterpreterDesignPattern;

public class TerminalExpression implements AbstractExpression {
    private String variable;

    public TerminalExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(variable);
    }
}
