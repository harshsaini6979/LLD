package PaymentGatewayDesign.User;

public class User {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String userId, String name, String email, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
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

    public UserDAO convertToUserDAO() {
        UserDAO userDAO = new UserDAO();
        userDAO.setId(userId);
        userDAO.setName(name);
        userDAO.setEmail(email);
        userDAO.setPhoneNumber(phoneNumber);

        return userDAO;
    }
}
