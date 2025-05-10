package AdapterDesignPattern;

import AdapterDesignPattern.Adaptor.WeightMachine;
import AdapterDesignPattern.Adaptor.WeightMachineImpl;

public class Main {

    public static void main(String[] args) {
        WeightMachine weightMachine = new WeightMachineImpl();

        System.out.println("Weight machine in Kilos: " + weightMachine.getWeightInKilograms() + " kg");
    }
}
