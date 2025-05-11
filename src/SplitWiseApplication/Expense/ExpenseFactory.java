package SplitWiseApplication.Expense;

import SplitWiseApplication.Controller;
import SplitWiseApplication.ExpenseStrategy.EqualSplit;
import SplitWiseApplication.ExpenseStrategy.ExpenseStrategy;
import SplitWiseApplication.ExpenseStrategy.PercentageSplit;
import SplitWiseApplication.ExpenseStrategy.UnEqualSplit;
import SplitWiseApplication.Group;
import SplitWiseApplication.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseFactory {
    Expense expense;
    User payer;
    List<User> users = new ArrayList<>();
    Group group;
    String expenseName;
    double amount;
    ExpenseStrategy expenseStrategy;

    public Expense getExpense(Controller controller) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of expense (UserExpense/GroupExpense): ");
        String type = scanner.nextLine();

        System.out.print("Enter the name of the expense: ");
        String expenseName = scanner.nextLine();

        System.out.print("Enter the payer's ID: ");
        String payerId = scanner.nextLine();

        payer = controller.getUser(payerId);
        if (payer == null) {
            System.out.println("Payer not found");
            return null;
        }

        System.out.print("Enter the amount: ");
        amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("1. Equal Split");
        System.out.println("2. Unequal Split");
        System.out.println("3. Percentage Split");
        System.out.print("Enter the strategy: ");
        int strategy = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (strategy) {
            case 1:
                expenseStrategy = new EqualSplit();
                break;
            case 2:
                expenseStrategy = new UnEqualSplit();
                break;
            case 3:
                expenseStrategy = new PercentageSplit();
                break;
            default:
                System.out.println("Invalid strategy");
                return null;
        }


        if (type.equals("UserExpense")) {
            System.out.print("Enter the IDs of the users (comma separated): ");
            String userIds = scanner.nextLine();
            String[] userIdArray = userIds.split(",");
            for (String userId : userIdArray) {
                User user = controller.getUser(userId.trim());
                if (user != null) {
                    users.add(user);
                } else {
                    System.out.println("User " + userId + " not found");
                    return null;
                }
            }
            expense = new UserExpense(expenseName, payer, users, expenseStrategy, amount);
        } else if (type.equals("GroupExpense")) {
            String groupId;

            System.out.print("Enter the group ID: ");
            groupId = scanner.nextLine();

            group = controller.getGroup(groupId);
            expense = new GroupExpense(expenseName, payer, group, expenseStrategy, amount);
        } else {
            System.out.println("Invalid expense type");
            return null;
        }

        return expense;
    }
}
