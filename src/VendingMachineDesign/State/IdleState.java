package VendingMachineDesign.State;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.ItemShelf;
import VendingMachineDesign.VendingMachine;

import java.util.Map;
import java.util.Scanner;

public class IdleState implements State{

    public IdleState(VendingMachine vendingMachine) {
        selectProduct(vendingMachine);
    }
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        for (ItemShelf itemShelf : vendingMachine.getInventory().getItemShelfList()) {
            System.out.println(itemShelf.getItemType().toString());
            for (Item item : itemShelf.getItemList()) {
                System.out.println(item.getItemId() + " | " + item.getName() + " | Price: " + item.getPrice() + " | Current stock: " + item.getQuantity());
            }
        }

        System.out.println("Please select a product (itemId, qyantity):");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArray = input.split(",");

        Item item = new Item(Integer.parseInt(inputArray[0].trim()), null, 0, "", Integer.parseInt(inputArray[1].trim()));

        vendingMachine.setVendingMachineState(new WorkingState());
        vendingMachine.getVendingMachineState().chooseItem(vendingMachine, item);
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Not Valid State");
    }

    @Override
    public void pressCancelButton(VendingMachine vendingMachine) {
        System.out.println("Not Valid State");
    }

    @Override
    public void chooseItem(VendingMachine vendingMachine, Item item) {
        System.out.println("Not Valid State");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine, Map<Coin, Integer> coins) {
        System.out.println("Not Valid State");
    }
}
