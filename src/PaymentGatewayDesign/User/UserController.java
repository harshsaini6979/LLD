package PaymentGatewayDesign.User;

import java.util.List;

public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(String id, String name, String email, String phoneNumber) {
        UserDAO userDAO = new UserDAO();
        userDAO.setId(id);
        userDAO.setName(name);
        userDAO.setEmail(email);
        userDAO.setPhoneNumber(phoneNumber);

        userService.addUser(userDAO);
    }

    public void getUser(String userId) {
        UserDAO user = userService.getUser(userId);
    }
}
