package InterpreterDesignPattern;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.assign("a", 5);
        context.assign("b", 10);
        context.assign("c", 15);

        AbstractExpression expression = new TerminalExpression("a");
        int result = expression.interpret(context);
        System.out.println("Result of interpreting 'a': " + result);

        expression = new TerminalExpression("b");
        result = expression.interpret(context);
        System.out.println("Result of interpreting 'b': " + result);

        expression = new TerminalExpression("c");
        result = expression.interpret(context);
        System.out.println("Result of interpreting 'c': " + result);

        result = new NonTerminalExpression(
            new TerminalExpression("a"),
            new NonTerminalExpression(
                new TerminalExpression("b"),
                new TerminalExpression("c"),
                "+"
            ),
            "*"
        ).interpret(context);

        System.out.println("Result of interpreting 'a * (b + c)': " + result);
    }
}
