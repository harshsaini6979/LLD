package VendingMachineDesign.State;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.VendingMachine;

import java.util.Map;

public interface State {
    public void selectProduct(VendingMachine vendingMachine);

    public void insertCoin(VendingMachine vendingMachine);

    public void pressCancelButton(VendingMachine vendingMachine);

    public void chooseItem(VendingMachine vendingMachine, Item item);

    public void dispenseItem(VendingMachine vendingMachine, Map<Coin, Integer> coins);
}
