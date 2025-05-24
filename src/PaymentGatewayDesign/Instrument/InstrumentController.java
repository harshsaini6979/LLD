package PaymentGatewayDesign.Instrument;

import PaymentGatewayDesign.Instrument.Service.InstrumentService;

import java.util.List;

public class InstrumentController {
    InstruementServiceFactory instrumentControllerFactory;

    public InstrumentController() {
        instrumentControllerFactory = new InstruementServiceFactory();
    }

    public InstrumentDAO addInstrument(InstrumentDAO instrument) {
        InstrumentService instrumentService = instrumentControllerFactory.getInstrumentService(instrument.getInstrumentType());

        return instrumentService.addInstrument(instrument);
    }

    public List<InstrumentDAO> getAllInstrument(String userId) {
        InstrumentService bankService = instrumentControllerFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService creditCardService = instrumentControllerFactory.getInstrumentService(InstrumentType.CREDIT_CARD);

        List<InstrumentDAO> bankInstruments = bankService.getInstrument(userId);
        List<InstrumentDAO> creditCardInstruments = creditCardService.getInstrument(userId);

        bankInstruments.addAll(creditCardInstruments);

        return bankInstruments;
    }

    public InstrumentDAO getInstrumentById(String userId, String instrumentId) {
        List<InstrumentDAO> instruments = getAllInstrument(userId);

        for (InstrumentDAO instrument : instruments) {
            if (instrument.getInstrumentId().equals(instrumentId)) {
                return instrument;
            }
        }

        return null;
    }
}
