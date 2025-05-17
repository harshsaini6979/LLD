package ZeptoDesign.Page;

import ZeptoDesign.Address;
import ZeptoDesign.Inventory;
import ZeptoDesign.Product.Product;
import ZeptoDesign.Product.ProductController;
import ZeptoDesign.Warehouse.Warehouse;
import ZeptoDesign.Warehouse.WarehouseController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminPage {
    Inventory inventory;

    public AdminPage(Inventory inventory) {
        this.inventory = inventory;
    }

    public void adminPage() {
        Scanner scanner = new Scanner(System.in);
        WarehouseController warehouseController = inventory.getWarehouseController();

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Add Warehouse");
            System.out.println("4. View Warehouse details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Available warehouses: ");
                    for (Warehouse warehouse: warehouseController.getAllWarehouses()) {
                        System.out.print("(" + warehouse.getWareHouseId() + ", " + warehouse.getWareHouseName() + ") ");
                    }
                    System.out.println();

                    System.out.print("Enter warehouse ID to add product: ");
                    int warehouseId = scanner.nextInt();

                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product price: ");
                    int productPrice = scanner.nextInt();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();

                    inventory.addProductInMap(productId, productName);

                    warehouseController.addProduct(warehouseId, new Product(productId, productName, productPrice, productQuantity));
                    break;
                case 2:
                    System.out.print("Available warehouses: ");
                    for (Warehouse warehouse: warehouseController.getAllWarehouses()) {
                        System.out.print("(" + warehouse.getWareHouseId() + ", " + warehouse.getWareHouseName() + ") ");
                    }
                    System.out.println();

                    System.out.print("Enter warehouse ID to add product: ");
                    warehouseId = scanner.nextInt();

                    System.out.print("Enter product ID: ");
                    productId = scanner.nextInt();

                    warehouseController.removeProduct(warehouseId, productId);
                    break;
                case 3:
                    System.out.print("Enter warehouse ID: ");
                    int wareHouseId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    System.out.print("Enter warehouse name: ");
                    String wareHouseName = scanner.nextLine();

                    System.out.println("Enter address details: ");
                    String addressLine1 = scanner.nextLine();

                    System.out.println("Enter zipcode: ");
                    int zipCode = scanner.nextInt();

                    Address address = new Address(addressLine1, zipCode);

                    Map<Integer, Product> productMap = new HashMap<>();
                    ProductController productController = new ProductController(productMap);

                    inventory.addWareHouse(new Warehouse(wareHouseId, wareHouseName, address, productController));
                    break;
                case 4:
                    System.out.print("Available warehouses: ");
                    for (Warehouse warehouse: warehouseController.getAllWarehouses()) {
                        System.out.print("(" + warehouse.getWareHouseId() + ", " + warehouse.getWareHouseName() + ") ");
                    }
                    System.out.println();

                    System.out.print("Enter warehouse ID to view details: ");
                    warehouseId = scanner.nextInt();

                    Warehouse warehouse = warehouseController.getWarehouse(warehouseId);
                    warehouse.printWarehouse();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
