package PaymentGatewayDesign.Transaction;

import java.util.List;

public class TransactionController {
    TransactionService transactionService;

    public TransactionController () {
        this.transactionService = new TransactionService();
    }

    public TransactionDAO makePayment(TransactionDAO transactionDAO) {
        return transactionService.makePayment(transactionDAO);
    }

    public List<TransactionDAO> getTransactionsHistory(String userId) {
        return transactionService.getTransactionHistory(userId);
    }
}
