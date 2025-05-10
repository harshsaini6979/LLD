package VendingMachineDesign;

import java.util.ArrayList;
import java.util.List;

public class ItemShelf {
    private int shelfId;
    private int capacity;
    private int currentItemCount;
    private ItemType itemType;
    private List<Item> itemList = new ArrayList<>();

    public ItemShelf(int shelfId, int capacity, ItemType itemType) {
        this.shelfId = shelfId;
        this.capacity = capacity;
        this.currentItemCount = 0;
        this.itemType = itemType;
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentItemCount() {
        return currentItemCount;
    }

    public void setCurrentItemCount(int currentItemCount) {
        this.currentItemCount = currentItemCount;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        if (this.currentItemCount+1 > this.capacity) {
            System.out.println("Shelf is full. Cannot add more items.");
            return;
        }

        this.itemList.add(item);
        this.currentItemCount += 1;
    }
}
