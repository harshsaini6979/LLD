package ZeptoDesign;

import ZeptoDesign.Product.Product;
import ZeptoDesign.Product.ProductController;
import ZeptoDesign.Warehouse.Warehouse;
import ZeptoDesign.Warehouse.WarehouseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    WarehouseController warehouseController;
    Map<Integer, String> productMap;

    public Inventory() {
        this.productMap = new HashMap<>();
        this.warehouseController = new WarehouseController(getWarehouseList());
    }

    public void addWareHouse(Warehouse warehouse) {
        boolean success = warehouseController.addWarehouse(warehouse);

        if (!success)
            return;;

        for (Product product : warehouse.getAllProducts().values()) {
            addProductInMap(product.getProductId(), product.getProductName());
        }
    }

    public void addProductInMap(int productId, String productName) {
        productMap.put(productId, productName);
    }

    public List<Integer> getProductList() {
        return productMap.keySet().stream().toList();
    }

    public WarehouseController getWarehouseController() {
        return warehouseController;
    }

    public String getProductName(int productId) {
        return productMap.get(productId);
    }

    private Map<Integer, Warehouse> getWarehouseList() {
        Product product1 = new Product(1, "Product1", 100, 10);
        Product product2 = new Product(2, "Product2", 200, 20);
        Product product3 = new Product(3, "Product3", 300, 30);
        Product product4 = new Product(4, "Product4", 400, 40);
        Product product5 = new Product(5, "Product5", 500, 50);

        Map<Integer, Product> productMap1 = new HashMap<>();

        productMap1.put(1, product1);
        productMap1.put(2, product2);
        productMap1.put(3, product3);
        productMap1.put(4, product4);
        productMap1.put(5, product5);

        Address address1 = new Address("Kanpur - UP - India", 100);
        ProductController productController1 = new ProductController(productMap1);
        Warehouse warehouse1 = new Warehouse(1, "Warehouse1", address1, productController1);

        Product product6 = new Product(1, "Product1", 1000, 10);
        Product product7 = new Product(2, "Product2", 2000, 20);
        Product product8 = new Product(3, "Product3", 3000, 30);
        Product product9 = new Product(4, "Product4", 4000, 40);
        Product product10 = new Product(5, "Product5", 5000, 50);

        Map<Integer, Product> productMap2 = new HashMap<>();

        productMap2.put(1, product6);
        productMap2.put(2, product7);
        productMap2.put(3, product8);
        productMap2.put(4, product9);
        productMap2.put(5, product10);

        Address address2 = new Address("Ludhiana - UP - India", 1);
        ProductController productController2 = new ProductController(productMap2);
        Warehouse warehouse2 = new Warehouse(2, "Warehouse2", address2, productController2);

        addProductInMap(product1.getProductId(), product1.getProductName());
        addProductInMap(product2.getProductId(), product2.getProductName());
        addProductInMap(product3.getProductId(), product3.getProductName());
        addProductInMap(product4.getProductId(), product4.getProductName());
        addProductInMap(product5.getProductId(), product5.getProductName());
        addProductInMap(product6.getProductId(), product6.getProductName());
        addProductInMap(product7.getProductId(), product7.getProductName());
        addProductInMap(product8.getProductId(), product8.getProductName());
        addProductInMap(product9.getProductId(), product9.getProductName());
        addProductInMap(product10.getProductId(), product10.getProductName());

        Map<Integer, Warehouse> warehouseMap = new HashMap<>();
        warehouseMap.put(1, warehouse1);
        warehouseMap.put(2, warehouse2);

        return warehouseMap;
    }
}
