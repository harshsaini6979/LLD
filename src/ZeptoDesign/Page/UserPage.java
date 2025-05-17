package ZeptoDesign.Page;

import ZeptoDesign.Address;
import ZeptoDesign.Inventory;
import ZeptoDesign.User.User;
import ZeptoDesign.User.UserController;

import java.util.Scanner;

public class UserPage {
    UserController userController;
    Inventory inventory;

    public UserPage(UserController userController, Inventory inventory) {
        this.userController = userController;
        this.inventory = inventory;
    }

    public void userPage() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to the User Page");
            System.out.println("1. Go to user profile");
            System.out.println("2. Add user");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Avaiable users: ");
                    userController.getAllUsers();
                    System.out.print("Enter user Id: ");
                    String userId = scanner.nextLine();

                    if (userController.checkUser(userId))
                        userController.userPage(userId);
                    break;
                case 2:
                    System.out.print("Enter user Id: ");
                    String newUserId = scanner.nextLine();

                    if (userController.checkUser(newUserId)) {
                        System.out.println("User already exists.");
                        continue;
                    }

                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();

                    System.out.println("Enter address details: ");
                    String addressLine1 = scanner.nextLine();

                    System.out.println("Enter zipcode: ");
                    int zipCode = scanner.nextInt();

                    Address address = new Address(addressLine1, zipCode);

                    User user = new User(newUserId, userName, address, inventory);
                    userController.addUser(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
