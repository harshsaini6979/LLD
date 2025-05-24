package PaymentGatewayDesign.Instrument;

import PaymentGatewayDesign.Instrument.Service.BankInstrumentService;
import PaymentGatewayDesign.Instrument.Service.CreditCardInstrumentService;
import PaymentGatewayDesign.Instrument.Service.InstrumentService;

public class InstruementServiceFactory {
    public InstrumentService getInstrumentService(InstrumentType instrumentType) {
        if (instrumentType == null) {
            return null;
        }

        if (instrumentType == InstrumentType.BANK)
            return new BankInstrumentService();
        else if (instrumentType == InstrumentType.CREDIT_CARD)
            return new CreditCardInstrumentService();

        return null;
    }
}
