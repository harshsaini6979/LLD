package TemplateDesignPattern;

public class PayToFriendFlow extends PaymentFlow {
    @Override
    public void validate() {
        System.out.println("Validating PayToFriendFlow");
    }

    @Override
    public void debit() {
        System.out.println("Debiting PayToFriendFlow");
    }

    @Override
    public void calculateFees() {
        System.out.println("Calculating fees for PayToFriendFlow");
    }

    @Override
    public void credit() {
        System.out.println("Crediting PayToFriendFlow");
    }
}
