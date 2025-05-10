package AdapterDesignPattern.Adaptor;

import AdapterDesignPattern.Adaptee.WeighingMachine;
import AdapterDesignPattern.Adaptee.WeighingMachineImpl;

public class WeightMachineImpl implements WeightMachine{
    private WeighingMachine weighingMachine;

    public WeightMachineImpl() {
        this.weighingMachine = new WeighingMachineImpl();
    }

    @Override
    public double getWeightInKilograms() {
        return weighingMachine.getWeightInPounds()*0.45;
    }
}
