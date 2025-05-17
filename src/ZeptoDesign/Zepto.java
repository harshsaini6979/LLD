package ZeptoDesign;

import ZeptoDesign.Page.AdminPage;
import ZeptoDesign.Page.UserPage;
import ZeptoDesign.User.User;
import ZeptoDesign.User.UserController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zepto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Inventory inventory = new Inventory();
        UserController userController = new UserController(getUsers(inventory), inventory);

        while (true) {
            System.out.println("1. Go to userpage");
            System.out.println("2. Go to adminpage");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new UserPage(userController, inventory).userPage();
                    break;
                case 2:
                    new AdminPage(inventory).adminPage();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Map<String, User> getUsers(Inventory inventory) {
        User user1 = new User("1", "Harsh Saini", new Address("Kanpur", 2), inventory);
        user1.addToCart(1, 2);
        user1.addToCart(2, 3);

        User user2 = new User("2", "Kunjika Saini", new Address("Kanpur", 200), inventory);
        user2.addToCart(4, 1);
        user2.addToCart(5, 20);

        Map<String, User> userMap = new HashMap<>();
        userMap.put(user1.getUserId(), user1);
        userMap.put(user2.getUserId(), user2);

        return userMap;
    }
}
