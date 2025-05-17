package ZeptoDesign.Product;

public class Product {
    int productId;
    String productName;
    int productPrice;
    int productQuantity;

    public Product(int productId, String productName, int productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }
}
