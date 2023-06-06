package CarRentalSystem;

public class Payment {
    public boolean payBill (Bill bill, double amount) {
        if (bill.totalBill == amount) {
            bill.isPaid = true;
            return true;
        }
        return false;
    }
}
