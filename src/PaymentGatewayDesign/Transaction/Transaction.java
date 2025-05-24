package PaymentGatewayDesign.Transaction;

public class Transaction {
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

    public TransactionDAO toTransactionDAO() {
        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.setTransactionId(this.transactionId);
        transactionDAO.setAmount(this.amount);
        transactionDAO.setSenderId(this.senderId);
        transactionDAO.setReceiverId(this.receiverId);
        transactionDAO.setDebitInstrumentId(this.debitInstrumentId);
        transactionDAO.setCreditInstrumentId(this.creditInstrumentId);
        transactionDAO.setStatus(this.status);
        return transactionDAO;
    }
}
