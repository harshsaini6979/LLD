package ZeptoDesign.User;

import ZeptoDesign.Address;
import ZeptoDesign.Inventory;
import ZeptoDesign.Order.Cart;
import ZeptoDesign.Order.Invoice;
import ZeptoDesign.Order.Order;
import ZeptoDesign.Order.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    String usreId;
    String userName;
    Address address;
    Cart cart;
    List<Invoice> invoices;
    Inventory inventory;

    public User(String usreId, String userName, Address address, Inventory inventory) {
        this.usreId = usreId;
        this.userName = userName;
        this.address = address;
        this.cart = new Cart(inventory);
        this.invoices = new ArrayList<>();
        this.inventory = inventory;
    }

    public String getUserId() {
        return usreId;
    }

    public String getUserName() {
        return userName;
    }

    public void addToCart(int productId, int count) {
        cart.addProduct(productId, count);
    }

    public void removeFromCart(int productId, int count) {
        cart.removeProduct(productId, count);
    }

    public void placeOrder() {
        Order order = new Order(invoices.toArray().length+1, cart, new Payment(), inventory.getWarehouseController(), address);

        Invoice invoice = order.placeOrder();

        if (invoice != null) {
            invoices.add(invoice);

            invoice.printInvoice();
        } else {
            System.out.println("Order failed");
        }
    }

    public void printCartProducts() {
        cart.printCart();
    }

    public void printAllProducts() {
        System.out.println("Available products: ");
        int counter = 1;
        for (int productId : inventory.getProductList()) {
            System.out.print("(" + productId + ": " + inventory.getProductName(productId) + ") ");
            if (counter++% 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome " + userName + "\t\tCurrent items in the cart:" + cart.getCount());
            System.out.println("1. Add to cart");
            System.out.println("2. Remove from cart");
            System.out.println("3. Place order");
            System.out.println("4. View invoices");
            System.out.println("5. View cart");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printAllProducts();
                    System.out.print("Enter product id: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter count: ");
                    int count = scanner.nextInt();
                    addToCart(productId, count);
                    System.out.println("Product added to cart: " + productId + ", Quantity: " + count);
                    break;
                case 2:
                    printCartProducts();
                    System.out.print("Enter product id: ");
                    productId = scanner.nextInt();
                    System.out.print("Enter count: ");
                    count = scanner.nextInt();
                    removeFromCart(productId, count);
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    for (Invoice invoice : invoices) {
                        invoice.printInvoice();
                    }
                    break;
                case 5:
                    cart.printCart();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
