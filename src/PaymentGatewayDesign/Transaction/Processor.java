package PaymentGatewayDesign.Transaction;

import PaymentGatewayDesign.Instrument.InstrumentDAO;

public class Processor {
    public void processTransaction(InstrumentDAO senderInstrument, InstrumentDAO receiverInstrument, int amount) {
        // Validate instruments
        if (senderInstrument == null || receiverInstrument == null) {
            throw new IllegalArgumentException("Invalid instruments provided for transaction.");
        }

        // Check if sender has sufficient balance (this is a placeholder, actual balance check logic will depend on the instrument type)
        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero.");
        }

        // Process the transaction
        System.out.println("Processing transaction of amount: " + amount + " from " + senderInstrument.getUserId() + " to " + receiverInstrument.getUserId());

        // Update balances, log transaction, etc. (placeholder for actual implementation)
    }
}
