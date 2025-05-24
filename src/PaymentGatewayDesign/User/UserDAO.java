package PaymentGatewayDesign.User;

public class UserDAO {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    public String getId() {
        return name;
    }

    public String setId(String id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User convertToUser() {
        User user = new User(id, name, email, phoneNumber);

        return user;
    }
}
