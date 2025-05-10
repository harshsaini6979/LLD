package VendingMachineDesign.State;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.ItemShelf;
import VendingMachineDesign.VendingMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DispenseState implements State{
    Map<Coin, Integer> userCoinMap = new HashMap<>();
    Item userItem;

    public DispenseState(Item userItem) {
        this.userItem = userItem;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        int amount = 0;

        for (ItemShelf itemShelf : vendingMachine.getInventory().getItemShelfList()) {
            for (Item item : itemShelf.getItemList()) {
                if (item.getItemId() == userItem.getItemId()) {
                    amount = item.getPrice() * userItem.getQuantity();
                    userItem.setName(item.getName());
                    break;
                }
            }
        }

        System.out.println("Amount to insert: " + amount);

        System.out.println("Enter the coins (dominance1:quantity1,dominance2:quantity2):");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] coins = input.split(",");

        try {
            for (String coin : coins) {
                String[] coinDetails = coin.split(":");

                Coin coinType = Coin.getNameByValue(Integer.parseInt(coinDetails[0]));
                int quantity = Integer.parseInt(coinDetails[1]);

                userCoinMap.put(coinType, quantity);
            }

            Map<Coin, Integer> change = vendingMachine.getInventory().payment(userCoinMap, amount);

            if (change == null) {
                System.out.println("Insufficient amount inserted. Please try again.");
                vendingMachine.setVendingMachineState(new WorkingState());
                vendingMachine.getVendingMachineState().chooseItem(vendingMachine, userItem);
            } else {
                dispenseItem(vendingMachine, change);
            }
        }
        catch (Exception e) {
            System.out.println("Invalid selection was made!!");
            vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
            vendingMachine.getVendingMachineState().selectProduct(vendingMachine);
        }

    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine, Map<Coin, Integer> coins) {
        System.out.println("Dispensing item: " + userItem.getName());
        System.out.println("Quantity: " + userItem.getQuantity());
        System.out.println("Please collect your item.");

        System.out.println("Please collect your change:");
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();

            if (entry.getValue() > 0){
                System.out.println(coin.getValue() + ":" + entry.getValue());
            }
        }

        for (ItemShelf itemShelf : vendingMachine.getInventory().getItemShelfList()) {
            for (Item item : itemShelf.getItemList()) {
                if (item.getItemId() == userItem.getItemId()) {
                    item.setQuantity(item.getQuantity() - userItem.getQuantity());
                    break;
                }
            }
        }

        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        vendingMachine.getVendingMachineState().selectProduct(vendingMachine);
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine) {
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
}
