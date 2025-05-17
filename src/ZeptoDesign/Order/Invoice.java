package ZeptoDesign.Order;

import ZeptoDesign.Product.Product;
import ZeptoDesign.Warehouse.Warehouse;

import java.util.Map;

public class Invoice {
    Map<Product, Integer> productList;
    int totalPrice;
    int orderId;
    Warehouse warehouse;

    public Invoice(Map<Product, Integer> productList, int totalPrice, int orderId, Warehouse warehouse) {
        this.productList = productList;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
        this.warehouse = warehouse;
    }

    public void printInvoice() {
        System.out.print("[Invoice ID: " + orderId);
        System.out.print(" | Warehouse: " + warehouse.getWareHouseName());
        System.out.print(" | Products: ");
        for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
            Product product = entry.getKey();
            System.out.print("(" + product.getProductName() + " : " + entry.getValue() + ") ");
        }
        System.out.print("| Total Price: " + totalPrice);
        System.out.println("]");
    }
}
