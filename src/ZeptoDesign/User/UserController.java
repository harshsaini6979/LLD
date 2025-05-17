package ZeptoDesign.User;

import ZeptoDesign.Inventory;

import java.util.Map;

public class UserController {
    Map<String, User> userMap;
    Inventory inventory;

    public UserController(Map<String, User> userMap, Inventory inventory) {
        this.userMap = userMap;
        this.inventory = inventory;
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);

        System.out.println("User added successfully");
    }

    public void getAllUsers() {
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.println(entry.getValue().getUserId() + ": " + entry.getValue().getUserName());
        }
    }

    public void userPage(String userId) {
        userMap.get(userId).menu();
    }

    public boolean checkUser(String userId) {
        if (userMap.containsKey(userId)) {
            return true;
        } else {
            return false;
        }
    }
}
