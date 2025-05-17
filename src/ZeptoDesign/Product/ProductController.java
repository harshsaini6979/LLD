package ZeptoDesign.Product;

import java.util.Map;

public class ProductController {
    Map<Integer, Product> productMap;

    public ProductController(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }
    public void addProduct(Product product) {
        if (productMap.containsKey(product.productId)){
            System.out.println("Product already exists");
            return;
        }
        productMap.put(product.productId, product);
        System.out.println("Product added successfully");
    }

    public void removeProduct(int productId) {
        productMap.remove(productId);
        System.out.println("Product removed successfully");
    }

    public Map<Integer, Product> getAllProducts() {
        return productMap;
    }

    public void updateProduct(int productId, int count) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setProductQuantity(product.getProductQuantity() + count);
        }
    }
}
