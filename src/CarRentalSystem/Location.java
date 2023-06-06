package CarRentalSystem;

public class Location {
    String address;
    int pincode;
    String city;
    String state;
    String country;

    public Location(String address, int pincode, String city, String state, String country) {
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
