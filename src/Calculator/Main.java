package Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArithmaticExpression num1 = new Number(1);

        ArithmaticExpression num2 = new Number(2);
        ArithmaticExpression num3 = new Number(3);

        ArithmaticExpression expression1 = new Expression(num2, num3, Operation.ADD);
        ArithmaticExpression expression2 = new Expression(num1, expression1, Operation.MULTIPLY);

        System.out.println(expression2.evaluate());
    }
}
