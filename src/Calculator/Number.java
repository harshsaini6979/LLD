package Calculator;

public class Number implements ArithmaticExpression{
    double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return this.value;
    }
}
