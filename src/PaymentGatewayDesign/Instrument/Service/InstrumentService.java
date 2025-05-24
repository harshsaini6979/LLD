package PaymentGatewayDesign.Instrument.Service;

import PaymentGatewayDesign.Instrument.Entity.Instrument;
import PaymentGatewayDesign.Instrument.InstrumentDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    static Map<String, List<Instrument>> userInstruments = new HashMap<>();

    public abstract InstrumentDAO addInstrument(InstrumentDAO instrumentDAO);

    public abstract List<InstrumentDAO> getInstrument(String instrumentId);
}
