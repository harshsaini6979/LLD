package VendingMachineDesign;

public class Item {
    private int itemId;
    private ItemType itemType;
    private int price;
    private String name;
    private int quantity;

    public Item(int itemId, ItemType itemType, int price, String name, int quantity) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public ItemType getItemType() {
        return itemType;
    }
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
}
