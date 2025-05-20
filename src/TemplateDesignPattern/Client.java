package TemplateDesignPattern;

public class Client {
    public static void main(String[] args) {
        PaymentFlow payToMerchantFlow = new PayToMerchantFlow();
        payToMerchantFlow.processPayment();

        System.out.println("===================================");

        PaymentFlow payToFriendFlow = new PayToFriendFlow();
        payToFriendFlow.processPayment();
    }
}
