package ZeptoDesign;

public class Address {
    String addressLine1;
    int zipCode;

    public Address(String addressLine1, int zipCode) {
        this.addressLine1 = addressLine1;
        this.zipCode = zipCode;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
