package PaymentGatewayDesign.Instrument.Service;

import PaymentGatewayDesign.Instrument.Entity.CreditCardInstrument;
import PaymentGatewayDesign.Instrument.Entity.Instrument;
import PaymentGatewayDesign.Instrument.InstrumentDAO;
import PaymentGatewayDesign.Instrument.InstrumentType;

import java.util.ArrayList;
import java.util.List;

public class CreditCardInstrumentService extends InstrumentService {
    @Override
    public InstrumentDAO addInstrument(InstrumentDAO instrument) {
        CreditCardInstrument creditCardInstrument = new CreditCardInstrument();
        creditCardInstrument.setInstrumentId(instrument.getInstrumentId());
        creditCardInstrument.setUserId(instrument.getUserId());
        creditCardInstrument.setInstrumentType(InstrumentType.CREDIT_CARD);
        creditCardInstrument.setCardNumber(instrument.getCardNumber());
        creditCardInstrument.setCvv(instrument.getCvv());

        List<Instrument> instruments = userInstruments.get(instrument.getUserId());

        if (instruments == null) {
            instruments = new ArrayList<>();
            userInstruments.put(instrument.getUserId(), instruments);
        }

        instruments.add(creditCardInstrument);

        return instrument;
    }

    @Override
    public List<InstrumentDAO> getInstrument(String userId) {
        List<Instrument> instruments = userInstruments.get(userId);
        List<InstrumentDAO> instrumentDAOs = new ArrayList<>();

        if (instruments != null) {
            for (Instrument instrument : instruments) {
                if (!(instrument instanceof CreditCardInstrument)) {
                    continue; // Skip if the instrument is not a CreditCardInstrument
                }
                InstrumentDAO instrumentDAO = new InstrumentDAO();
                instrumentDAO.setInstrumentId(instrument.getInstrumentId());
                instrumentDAO.setUserId(instrument.getUserId());
                instrumentDAO.setInstrumentType(instrument.getInstrumentType());

                instrumentDAOs.add(instrumentDAO);
            }
        }

        return instrumentDAOs;
    }
}
