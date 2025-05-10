package VendingMachineDesign;

import VendingMachineDesign.State.IdleState;
import VendingMachineDesign.State.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;

    public VendingMachine() {
        this.inventory = new Inventory(setItemShelf(), setCoinMap());
    }

    public void run() {
        this.vendingMachineState = new IdleState(this);
    }

    public State getVendingMachineState() {
        return this.vendingMachineState;
    }

    public void setVendingMachineState(State state) {
        this.vendingMachineState = state;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<ItemShelf> setItemShelf() {
        Item item1 = new Item(1, ItemType.BEVERAGE, 20, "Cola", 20);
        Item item2 = new Item(2, ItemType.BEVERAGE, 20, "Pepsi", 20);
        Item item3 = new Item(3, ItemType.BEVERAGE, 20, "Fanta", 20);
        ItemShelf itemShelf1 = new ItemShelf(100, 5, ItemType.BEVERAGE);
        itemShelf1.addItem(item1);
        itemShelf1.addItem(item2);
        itemShelf1.addItem(item3);
        Item item4 = new Item(4, ItemType.SNACK, 10, "Chips", 10);
        Item item5 = new Item(5, ItemType.SNACK, 50, "Chocolate", 10);
        Item item6 = new Item(6, ItemType.SNACK, 2, "Candy", 1000);
        ItemShelf itemShelf2 = new ItemShelf(100, 5, ItemType.SNACK);
        itemShelf2.addItem(item4);
        itemShelf2.addItem(item5);
        itemShelf2.addItem(item6);
        Item item7 = new Item(7, ItemType.FRUIT, 10, "Apple", 50);
        Item item8 = new Item(8, ItemType.FRUIT, 4, "Banana", 50);
        Item item9 = new Item(9, ItemType.FRUIT, 30, "Orange", 50);
        Item item10 = new Item(10, ItemType.FRUIT, 40, "Grapes", 10);
        ItemShelf itemShelf3 = new ItemShelf(100, 5, ItemType.FRUIT);
        itemShelf3.addItem(item7);
        itemShelf3.addItem(item8);
        itemShelf3.addItem(item9);
        itemShelf3.addItem(item10);

        List<ItemShelf> itemShelfList = new ArrayList<>();
        itemShelfList.add(itemShelf1);
        itemShelfList.add(itemShelf2);
        itemShelfList.add(itemShelf3);

        return itemShelfList;
    }

    public Map<Coin, Integer> setCoinMap() {
        Map<Coin, Integer> coins = new HashMap<>();
        coins.put(Coin.ONE, 10);
        coins.put(Coin.TWO, 10);
        coins.put(Coin.FIVE, 10);
        coins.put(Coin.TEN, 10);
        coins.put(Coin.TWENTY, 10);
        coins.put(Coin.FIFTY, 10);
        coins.put(Coin.HUNDRED, 10);
        coins.put(Coin.TWOHUNDRED, 10);

        return coins;
    }

}
