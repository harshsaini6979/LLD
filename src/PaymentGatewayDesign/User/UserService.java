package PaymentGatewayDesign.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User> users = new ArrayList<>();

    public void addUser(UserDAO userDAO) {
        User user = userDAO.convertToUser();

        users.add(user);
    }

    public UserDAO getUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user.convertToUserDAO();
            }
        }

        return null;
    }

}
