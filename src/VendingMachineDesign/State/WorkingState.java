package VendingMachineDesign.State;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.ItemShelf;
import VendingMachineDesign.VendingMachine;

import java.util.Map;
import java.util.Scanner;

public class WorkingState implements State{
    @Override
    public void chooseItem(VendingMachine vendingMachine, Item item) {
        for (ItemShelf itemShelf : vendingMachine.getInventory().getItemShelfList()) {
            for (Item item1 : itemShelf.getItemList()) {
                if (item.getItemId() == item1.getItemId() && item1.getQuantity() >= item.getQuantity()) {
                    System.out.println("Item details captured successfully!!");

                    System.out.println("1. Continue for the payment");
                    System.out.println("2. Cancel the order");

                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();

                    if (choice == 1){
                        vendingMachine.setVendingMachineState(new DispenseState(item));
                        vendingMachine.getVendingMachineState().insertCoin(vendingMachine);
                    }
                    else if (choice == 2) {
                        vendingMachine.getVendingMachineState().pressCancelButton(vendingMachine);
                    }
                    else {
                        System.out.println("Invalid selection was made!!");
                        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
                        vendingMachine.getVendingMachineState().selectProduct(vendingMachine);
                    }

                }
            }
        }

        System.out.println("Invalid selection was made!!");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        vendingMachine.getVendingMachineState().selectProduct(vendingMachine);
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Not Valid State");
    }

    @Override
    public void pressCancelButton(VendingMachine vendingMachine) {
        System.out.println("Previous selection was cancelled successfully!!");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        vendingMachine.getVendingMachineState().selectProduct(vendingMachine);
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Not Valid State");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine, Map<Coin, Integer> coins) {
        System.out.println("Not Valid State");
    }
}
