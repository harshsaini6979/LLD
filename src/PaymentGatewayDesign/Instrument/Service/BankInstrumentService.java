package PaymentGatewayDesign.Instrument.Service;

import PaymentGatewayDesign.Instrument.Entity.BankInstrument;
import PaymentGatewayDesign.Instrument.Entity.Instrument;
import PaymentGatewayDesign.Instrument.InstrumentDAO;
import PaymentGatewayDesign.Instrument.InstrumentType;

import java.util.ArrayList;
import java.util.List;

public class BankInstrumentService extends InstrumentService {
    @Override
    public InstrumentDAO addInstrument(InstrumentDAO instrument) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.setInstrumentId(instrument.getInstrumentId());
        bankInstrument.setInstrumentType(InstrumentType.BANK);
        bankInstrument.setBankAccountNumber(instrument.getBankAccountNumber());
        bankInstrument.setIfscCode(instrument.getIfsc());
        bankInstrument.setUserId(instrument.getUserId());

        List<Instrument> instruments = userInstruments.get(instrument.getUserId());

        if (instruments == null) {
            instruments = new ArrayList<>();
            userInstruments.put(instrument.getUserId(), instruments);
        }
        instruments.add(bankInstrument);

        return instrument;
    }

    @Override
    public List<InstrumentDAO> getInstrument(String userId) {
        List<Instrument> instruments = userInstruments.get(userId);
        List<InstrumentDAO> instrumentDAOs = new ArrayList<>();

        if (instruments != null) {
            for (Instrument instrument : instruments) {
                if (!(instrument instanceof BankInstrument)) {
                    continue; // Skip if the instrument is not a BankInstrument
                }
                InstrumentDAO instrumentDAO = new InstrumentDAO();
                instrumentDAO.setInstrumentId(instrument.getInstrumentId());
                instrumentDAO.setUserId(userId);
                instrumentDAO.setInstrumentType(instrument.getInstrumentType());
                instrumentDAOs.add(instrumentDAO);
            }
        }

        return instrumentDAOs;
    }
}
