package ZeptoDesign.Order;

public class Payment {
    public boolean processPayment(String paymentMethod, double amount) {
        try {
            // Logic to process payment
            System.out.println("Processing " + paymentMethod + " payment of amount: " + amount);
            Thread.sleep(100);
            System.out.println("Payment of amount " + amount + " processed successfully using " + paymentMethod);
            return true;
        }
        catch (InterruptedException e) {
            System.out.println("Payment processing interrupted");
        }

        return false;
    }
}
