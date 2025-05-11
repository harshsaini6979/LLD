package ATMDesign;

public class Card {
    String cardNo;
    String cardHolderName;
    String expiryDate;
    String cvv;
    private String pin;
    BankAccount bankAccount;

    public Card(String cardNo, String cardHolderName, String expiryDate, String cvv, BankAccount bankAccount, String pin) {
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.bankAccount = bankAccount;
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNo() {
        return cardNo;
    }
}
