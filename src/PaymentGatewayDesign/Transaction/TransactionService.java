package PaymentGatewayDesign.Transaction;

import PaymentGatewayDesign.Instrument.InstrumentController;
import PaymentGatewayDesign.Instrument.InstrumentDAO;

import java.util.*;

public class TransactionService {
    public static Map<String, List<Transaction>> transactions = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        this.instrumentController = new InstrumentController();
        this.processor = new Processor();
    }

    public List<TransactionDAO> getTransactionHistory(String userId) {
        List<TransactionDAO> transactionDAOs = new ArrayList<>();

        List<Transaction> userTransactions = transactions.get(userId);

        for (Transaction transaction : userTransactions) {
            transactionDAOs.add(transaction.toTransactionDAO());
        }

        return transactionDAOs;
    }

    public TransactionDAO makePayment(TransactionDAO transactionDAO) {
        InstrumentDAO senderInstrument = instrumentController.getInstrumentById(transactionDAO.getSenderId(), transactionDAO.getDebitInstrumentId());
        InstrumentDAO receiverInstrument = instrumentController.getInstrumentById(transactionDAO.getReceiverId(), transactionDAO.getCreditInstrumentId());

        processor.processTransaction(senderInstrument, receiverInstrument, transactionDAO.getAmount());

        Transaction transaction = transactionDAO.toTransaction();
        transaction.setTransactionId(String.valueOf(new Random().nextInt(100-10)+10));

        transaction.setStatus(TransactionStatus.SUCCESS);

        List<Transaction> senderTransactions = transactions.get(transactionDAO.getSenderId());

        if (senderTransactions == null) {
            senderTransactions = new ArrayList<>();
            transactions.put(transactionDAO.getSenderId(), senderTransactions);
        }
        senderTransactions.add(transaction);

        List<Transaction> receiverTransactions = transactions.get(transactionDAO.getReceiverId());
        if (receiverTransactions == null) {
            receiverTransactions = new ArrayList<>();
            transactions.put(transactionDAO.getReceiverId(), receiverTransactions);
        }
        receiverTransactions.add(transaction);

        transactionDAO.setTransactionId(transaction.getTransactionId());
        transactionDAO.setStatus(transaction.getStatus());

        return transactionDAO;
    }
}
