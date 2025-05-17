package ZeptoDesign.Order;

import ZeptoDesign.Inventory;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, Integer> productList;
    Inventory inventory;

    public Cart(Inventory inventory) {
        this.productList = new HashMap<>();
        this.inventory = inventory;
    }

    public void addProduct(int productId, int quantity) {
        if (productList.containsKey(productId)) {
            productList.put(productId, productList.get(productId) + quantity);
        } else {
            productList.put(productId, quantity);
        }
    }

    public void removeProduct(int productId, int quantity) {
        if (productList.containsKey(productId)) {
            productList.put(productId, Math.max(0, productList.get(productId) - quantity));

            if (productList.get(productId) <= 0) {
                productList.remove(productId);
            }
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public Map<Integer, Integer> getProductList() {
        return productList;
    }

    public int getCount() {
        return productList.size();
    }

    public void printCart() {
        System.out.println("Products in cart:");
        for (Map.Entry<Integer, Integer> entry : productList.entrySet()) {
            String productName = inventory.getProductName(entry.getKey());
            System.out.println("Product ID: " + entry.getKey() + ", Product Name: " + productName + ", Quantity: " + entry.getValue());
        }
    }
}
