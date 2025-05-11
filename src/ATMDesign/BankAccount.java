package ATMDesign;

public class BankAccount {
    String bankAccountNo;
    String bankAccountName;
    double balance;

    public BankAccount(String bankAccountNo, String bankAccountName, double balance) {
        this.bankAccountNo = bankAccountNo;
        this.bankAccountName = bankAccountName;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
