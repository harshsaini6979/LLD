package TemplateDesignPattern;

public abstract class PaymentFlow {
    public abstract void validate();
    public abstract void debit();
    public abstract void calculateFees();
    public abstract void credit();

    public final void processPayment() {
        validate();
        debit();
        calculateFees();
        credit();
    }
}
