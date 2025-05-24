package PaymentGatewayDesign;

import PaymentGatewayDesign.Instrument.InstrumentController;
import PaymentGatewayDesign.Instrument.InstrumentDAO;
import PaymentGatewayDesign.Instrument.InstrumentType;
import PaymentGatewayDesign.Transaction.TransactionController;
import PaymentGatewayDesign.Transaction.TransactionDAO;
import PaymentGatewayDesign.User.UserController;
import PaymentGatewayDesign.User.UserService;

public class PaymentGateway {

    public static void main(String args[]) {

        InstrumentController instrumentController = new InstrumentController();
        UserService userService = new UserService();
        UserController userController = new UserController(userService);
        TransactionController transactionController = new TransactionController();

//1. add USER1
        userController.addUser("1", "Harsh", "abc@gmail.com", "123456");

//1. add USER2
        userController.addUser("2", "Rohit", "bcd@gmail.com", "654321");

//add bank to User1

        InstrumentDAO bankInstrumentDO = new InstrumentDAO();
        bankInstrumentDO.setInstrumentId("100");
        bankInstrumentDO.setInstrumentType(InstrumentType.BANK);
        bankInstrumentDO.setUserId("1"); // Assuming userID for User1 is "1"
        bankInstrumentDO.setBankAccountNumber("1234567890");
        bankInstrumentDO.setIfsc("IFSC1234");

        InstrumentDAO user1BankInstrument = instrumentController.addInstrument(bankInstrumentDO);

        System.out.println("Bank Instrument created for User1:" + user1BankInstrument.getInstrumentId());

//add Card to User2
        InstrumentDAO cardInstrumentDO = new InstrumentDAO();
        cardInstrumentDO.setInstrumentId("200");
        cardInstrumentDO.setInstrumentType(InstrumentType.CREDIT_CARD);
        cardInstrumentDO.setUserId("2"); // Assuming userID for User2 is "2"
        cardInstrumentDO.setCardNumber("1234567890123456");
        cardInstrumentDO.setCvv("123");

        InstrumentDAO user2CardInstrument = instrumentController.addInstrument(cardInstrumentDO);

        System.out.println("Card Instrument created for User2:" + user2CardInstrument.getInstrumentId());
        
        //Make payment

        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.setAmount(10);
        transactionDAO.setSenderId(user1BankInstrument.getUserId());
        transactionDAO.setReceiverId(user2CardInstrument.getUserId());
        transactionDAO.setDebitInstrumentId(user1BankInstrument.getInstrumentId());
        transactionDAO.setCreditInstrumentId(user2CardInstrument.getInstrumentId());
        transactionController.makePayment(transactionDAO);

        //Get User1 Instruments
        System.out.println("User1 Instruments:");
        for (InstrumentDAO instrument : instrumentController.getAllInstrument(user1BankInstrument.getUserId())) {
            System.out.println("Instrument ID: " + instrument.getInstrumentId() + ", Type: " + instrument.getInstrumentType());
        }

        //Get User2 Instruments
        System.out.println("User2 Instruments:");
        for (InstrumentDAO instrument : instrumentController.getAllInstrument(user2CardInstrument.getUserId())) {
            System.out.println("Instrument ID: " + instrument.getInstrumentId() + ", Type: " + instrument.getInstrumentType());
        }

        //all transactions
        System.out.println("All Transactions:");
        for (TransactionDAO transaction : transactionController.getTransactionsHistory(user1BankInstrument.getUserId())) {
            System.out.println("Transaction ID: " + transaction.getTransactionId() +
                    ", Amount: " + transaction.getAmount() +
                    ", Sender: " + transaction.getSenderId() +
                    ", Receiver: " + transaction.getReceiverId() +
                    ", Debit Instrument: " + transaction.getDebitInstrumentId() +
                    ", Credit Instrument: " + transaction.getCreditInstrumentId());
        }

        for (TransactionDAO transaction : transactionController.getTransactionsHistory(user2CardInstrument.getUserId())) {
            System.out.println("Transaction ID: " + transaction.getTransactionId() +
                    ", Amount: " + transaction.getAmount() +
                    ", Sender: " + transaction.getSenderId() +
                    ", Receiver: " + transaction.getReceiverId() +
                    ", Debit Instrument: " + transaction.getDebitInstrumentId() +
                    ", Credit Instrument: " + transaction.getCreditInstrumentId());
        }
    }
}
