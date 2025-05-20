package TemplateDesignPattern;

public class PayToMerchantFlow extends PaymentFlow {
    @Override
    public void validate() {
        System.out.println("Validating PayToMerchant");
    }

    @Override
    public void debit() {
        System.out.println("Debiting PayToMerchant");
    }

    @Override
    public void calculateFees() {
        System.out.println("Calculating fees for PayToMerchant");
    }

    @Override
    public void credit() {
        System.out.println("Crediting PayToMerchant");
    }
}
