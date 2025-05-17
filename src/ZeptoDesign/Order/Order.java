package ZeptoDesign.Order;

import ZeptoDesign.Address;
import ZeptoDesign.Product.Product;
import ZeptoDesign.Warehouse.Warehouse;
import ZeptoDesign.Warehouse.WarehouseController;
import ZeptoDesign.Warehouse.WarehouseStrategy.CheapestWarehouseStrategy;
import ZeptoDesign.Warehouse.WarehouseStrategy.NearestWarehouseStrategy;
import ZeptoDesign.Warehouse.WarehouseStrategy.WarehouseStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    Address address;
    int orderId;
    Cart cart;
    Payment payment;
    WarehouseController warehouseController;

    public Order (int orderId, Cart cart, Payment payment, WarehouseController warehouseController, Address address) {
        this.orderId = orderId;
        this.cart = cart;
        this.payment = payment;
        this.warehouseController = warehouseController;
        this.address = address;
    }

    public Invoice placeOrder() {
        Scanner scanner = new Scanner(System.in);

        if (cart.getProductList().isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return null;
        }

        Map<Integer, Integer> selectedProducts = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : cart.getProductList().entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            System.out.print("Press Y to confirm the order for product ID " + productId + " with quantity " + quantity + ": ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                selectedProducts.put(productId, quantity);
            }
        }

        System.out.println("1. Nearest warehouse");
        System.out.println("2. Cheapest warehouse");
        System.out.print("Select warehouse strategy (1 or 2): ");
        int strategyChoice = scanner.nextInt();

        WarehouseStrategy warehouseStrategy = null;

        if(strategyChoice == 1)
            warehouseStrategy = new NearestWarehouseStrategy();
        else if(strategyChoice == 2)
            warehouseStrategy = new CheapestWarehouseStrategy();
        else {
            System.out.println("Invalid choice. Defaulting to nearest warehouse.");
            warehouseStrategy = new NearestWarehouseStrategy();
        }

        int totalAmount = warehouseController.buyProduct(selectedProducts, warehouseStrategy, address);

        if (totalAmount!=0) {
            if (!payment.processPayment("Cash", totalAmount)) {
                System.out.println("Payment failed. Please try again.");
                return null;
            }

            System.out.println("Order placed successfully.");

            Warehouse warehouse = warehouseStrategy.getWarehouse(warehouseController.getAllWarehouses(), address, selectedProducts);
            Map<Product, Integer> productList = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : selectedProducts.entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = warehouse.getProduct(productId);
                productList.put(product, quantity);
            }

            for (Map.Entry<Integer, Integer> entry : selectedProducts.entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                cart.removeProduct(productId, quantity);
            }

            return new Invoice(productList, totalAmount, orderId, warehouse);
        } else {
            System.out.println("Order placement failed. Please check product availability.");
            return null;
        }
    }
}
