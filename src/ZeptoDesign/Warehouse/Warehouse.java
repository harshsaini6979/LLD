package ZeptoDesign.Warehouse;

import ZeptoDesign.Address;
import ZeptoDesign.Product.Product;
import ZeptoDesign.Product.ProductController;

import java.util.Map;

public class Warehouse {
    int wareHouseId;
    String wareHouseName;
    Address address;
    ProductController productController;

    public Warehouse (int wareHouseId, String wareHouseName, Address address, ProductController productController) {
        this.wareHouseId = wareHouseId;
        this.wareHouseName = wareHouseName;
        this.address = address;
        this.productController = productController;
    }

    public int getWareHouseId() {
        return wareHouseId;
    }

    public void addProduct(Product product) {
        productController.addProduct(product);
    }

    public void removeProduct(int productId) {
        productController.removeProduct(productId);
    }

    public void updateProduct(int productId, int count) {
        productController.updateProduct(productId, count);
    }

    public Address getAddress() {
        return address;
    }

    public Map<Integer, Product> getAllProducts() {
        return productController.getAllProducts();
    }

    public String getWareHouseName () {
        return wareHouseName;
    }

    public int totalAmount(int productId, int count) {
        Product product = productController.getAllProducts().get(productId);
        if (product != null) {
            return product.getProductPrice() * count;
        }
        return 0;
    }

    public Product getProduct(int productId) {
        return productController.getAllProducts().get(productId);
    }

    public void printWarehouse() {
        System.out.println("Warehouse ID: " + wareHouseId);
        System.out.println("Warehouse Name: " + wareHouseName);
        System.out.println("Address: " + address.toString());
        System.out.println("Products: ");
        for (Map.Entry<Integer, Product> entry : productController.getAllProducts().entrySet()) {
            Product product = entry.getValue();
            System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getProductName() + ", Quantity: " + product.getProductQuantity() + ", Price: " + product.getProductPrice());
        }
    }
}
