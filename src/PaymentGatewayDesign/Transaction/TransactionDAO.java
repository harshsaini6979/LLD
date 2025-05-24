package PaymentGatewayDesign.Transaction;

public class TransactionDAO {
    String transactionId;
    int amount;
    String senderId;
    String receiverId;
    String debitInstrumentId;
    String creditInstrumentId;
    TransactionStatus status;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getDebitInstrumentId() {
        return debitInstrumentId;
    }

    public void setDebitInstrumentId(String debitInstrumentId) {
        this.debitInstrumentId = debitInstrumentId;
    }

    public String getCreditInstrumentId() {
        return creditInstrumentId;
    }

    public void setCreditInstrumentId(String creditInstrumentId) {
        this.creditInstrumentId = creditInstrumentId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Transaction toTransaction()  {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionId);
        transaction.setAmount(amount);
        transaction.setSenderId(senderId);
        transaction.setReceiverId(receiverId);
        transaction.setDebitInstrumentId(debitInstrumentId);
        transaction.setCreditInstrumentId(creditInstrumentId);
        transaction.setStatus(status);
        return transaction;
    }
}
