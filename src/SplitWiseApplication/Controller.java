package SplitWiseApplication;

import SplitWiseApplication.Expense.Expense;
import SplitWiseApplication.Expense.ExpenseFactory;
import SplitWiseApplication.Expense.GroupExpense;
import SplitWiseApplication.ExpenseStrategy.EqualSplit;
import SplitWiseApplication.ExpenseStrategy.ExpenseStrategy;

import java.util.*;

public class Controller {
    Map<String, User> allUsers;
    Map<String, Group> allGroups;
    ExpenseFactory expenseFactory = new ExpenseFactory();

    public Controller() {
        this.allUsers = new HashMap<>();
        this.allGroups = new HashMap<>();

        inialize();
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===================== Welcome to SplitWise! ===================== ");
        System.out.println("1. Add User");
        System.out.println("2. Add Group");
        System.out.println("3. Add User to Group");
        System.out.println("4. Remove User from Group");
        System.out.println("5. Add Expense");
        System.out.println("6. Display Users");
        System.out.println("7. Display Groups");
        System.out.println("8. Display User Balance Sheet");
        System.out.print("Please enter your choice: ");
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (input) {
            case 1:
                System.out.print("Enter User ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter User Name: ");
                String userName = scanner.nextLine();
                addUser(new User(userId, userName, "", ""));
                System.out.println("User added successfully.");
                break;
            case 2:
                System.out.print("Enter Group ID: ");
                String groupId = scanner.nextLine();
                System.out.print("Enter Group Name: ");
                String groupName = scanner.nextLine();
                System.out.print("Enter User IDs (comma separated): ");
                String userIds = scanner.nextLine();
                String[] userIdArray = userIds.split(",");

                List<User> users = new ArrayList<>();

                for (String id : userIdArray) {
                    User user = allUsers.get(id.trim());
                    if (user != null) {
                        users.add(user);
                    } else {
                        System.out.println("User with ID " + id.trim() + " not found.");
                    }
                }

                addGroup(new Group(groupId, groupName, users));
                System.out.println("Group added successfully.");
                break;
            case 3:
                System.out.print("Enter group ID: ");
                String groupIdToAdd = scanner.nextLine();
                System.out.print("Enter user ID: ");
                String userIdToAdd = scanner.nextLine();

                Group groupToAdd = allGroups.get(groupIdToAdd);
                User userToAdd = allUsers.get(userIdToAdd);

                if (groupToAdd != null && userToAdd != null) {
                    addUserToGroup(userToAdd, groupToAdd);
                    System.out.println("User added to group successfully.");
                } else {
                    System.out.println("Group or User not found.");
                }
                break;
            case 4:
                System.out.print("Enter group ID: ");
                String groupIdToRemove = scanner.nextLine();
                System.out.print("Enter user ID: ");
                String userIdToRemove = scanner.nextLine();

                Group groupToRemove = allGroups.get(groupIdToRemove);
                User userToRemove = allUsers.get(userIdToRemove);

                if (groupToRemove != null && userToRemove != null) {
                    removeUserFromGroup(userToRemove, groupToRemove);
                    System.out.println("User removed from group successfully.");
                } else {
                    System.out.println("Group or User not found.");
                }
                break;
            case 5:
                addExpenseToUser();
                break;
            case 6:
                System.out.println("Users:");
                for (User user : allUsers.values()) {
                    System.out.println(user.toString());
                }
                break;
            case 7:
                System.out.println("Groups:");
                for (Group group : allGroups.values()) {
                    System.out.println(group.toString());
                }
                break;
            case 8:
                System.out.print("Enter user ID: ");
                String userIdToDisplay = scanner.nextLine();
                User userToDisplay = allUsers.get(userIdToDisplay);

                if (userToDisplay != null) {
                    userToDisplay.getBalanceSheet().printBalanceSheet();
                } else {
                    System.out.println("User not found.");
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

    }

    public void addUser(User user) {
        allUsers.put(user.getUserId(), user);
    }

    public void addGroup(Group group) {
        allGroups.put(group.getGroupId(), group);
    }

    public void addUserToGroup(User user, Group group) {
        if (allUsers.containsKey(user.getUserId()) && allGroups.containsKey(group.getGroupId()))
            group.addUser(user);
        else
            System.out.println("User or Group not found");
    }

    public void removeUserFromGroup(User user, Group group) {
        if (allUsers.containsKey(user.getUserId()) && allGroups.containsKey(group.getGroupId()))
            group.removeUser(user);
        else
            System.out.println("User or Group not found");
    }

    public void addExpenseToUser() {
        ExpenseFactory expenseFactory = new ExpenseFactory();
        Expense expense = expenseFactory.getExpense(this);

        expense.updateBalanceSheet();
        System.out.println("Expense added successfully.");
    }

    public User getUser(String userId) {
        return allUsers.get(userId);
    }

    public Group getGroup(String groupId) {
        return allGroups.get(groupId);
    }

    private void inialize() {
        User user1 = new User("1", "Alice", "alice@gmail.com", "123456789");
        User user2 = new User("2", "Bob", "bob@gmail.com", "923456789");
        User user3 = new User("3", "John", "john@gmail.com", "923486789");
        addUser(user1);
        addUser(user2);
        addUser(user3);

        List<User> groupUsers1 = new ArrayList<>();
        groupUsers1.add(user1);
        groupUsers1.add(user2);
        Group group1 = new Group("1", "Friends", groupUsers1);

        List<User> groupUsers2 = new ArrayList<>();
        groupUsers2.add(user2);
        groupUsers2.add(user3);
        Group group2 = new Group("2", "Family", groupUsers2);

        addGroup(group1);
        addGroup(group2);

        ExpenseStrategy expenseStrategy = new EqualSplit();
        Expense expense1 = new GroupExpense("Dinner", user1, group1, expenseStrategy, 100.0);
        expense1.updateBalanceSheet();
    }
}
