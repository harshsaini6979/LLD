package VendingMachineDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<ItemShelf> itemShelfList;
    private Map<Coin, Integer> coinsMap;

    public Inventory(List<ItemShelf> itemShelfList, Map<Coin, Integer> coinsMap) {
        this.itemShelfList = itemShelfList;
        this.coinsMap = coinsMap;
    }

    public List<ItemShelf> getItemShelfList() {
        return itemShelfList;
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinsMap;
    }

    public void removeItemFromShelf(Item item) {
        for (ItemShelf itemShelf : itemShelfList){
            if (item.getItemType() == itemShelf.getItemType()) {
                for (Item item1 : itemShelf.getItemList()) {
                    if (item.getItemId() == item1.getItemId()) {
                        item1.setQuantity(item1.getQuantity() - item.getQuantity());
                        return;
                    }
                }
            }
        }
    }

    public void addItemToShelf(Item item) {
        for (ItemShelf itemShelf : itemShelfList){
            if (item.getItemType() == itemShelf.getItemType()) {
                for (Item item1 : itemShelf.getItemList()) {
                    if (item.getItemId() == item1.getItemId()) {
                        item1.setQuantity(item1.getQuantity() + item.getQuantity());
                        return;
                    }
                }
            }
        }
    }

    public Map<Coin, Integer> payment(Map<Coin, Integer> coins, int amount) {
        int total = 0;

        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            int count = entry.getValue();
            total += coin.getValue() * count;
        }

        if (total < amount) {
            System.out.println("Not enough coins");
            return null;
        }

        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                coinsMap.put(coin, coinsMap.getOrDefault(coin, 0) + count);
            }
        }

        Map<Coin, Integer> changeMap = new HashMap<>();
        int change = total - amount;

        for (Map.Entry<Coin, Integer> entry : coinsMap.entrySet()) {
            Coin coin = entry.getKey();
            int count = entry.getValue();
            while (change >= coin.getValue() && count > 0) {
                change -= coin.getValue();
                count--;
                changeMap.put(coin, changeMap.getOrDefault(coin, 0) + 1);
            }
        }

        return changeMap;
    }
}
