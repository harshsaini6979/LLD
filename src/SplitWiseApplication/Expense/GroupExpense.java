package SplitWiseApplication.Expense;

import SplitWiseApplication.ExpenseStrategy.ExpenseStrategy;
import SplitWiseApplication.Group;
import SplitWiseApplication.User;

import java.util.List;
import java.util.Map;

public class GroupExpense implements Expense {
    String expenseName;
    User payer;
    Group group;
    ExpenseStrategy expenseStrategy;
    double amount;
    Map<User, Double> userMap;

    public GroupExpense(String expenseName, User payer, Group group, ExpenseStrategy expenseStrategy, double amount) {
        this.expenseName = expenseName;
        this.payer = payer;
        this.group = group;
        this.expenseStrategy = expenseStrategy;
        this.amount = amount;
    }

    @Override
    public void updateBalanceSheet() {
        List<User> users = group.getUsers();
        userMap = expenseStrategy.compute(payer, amount, users);

        for (Map.Entry<User, Double> entry : userMap.entrySet()) {
            User user = entry.getKey();
            double share = entry.getValue();

            user.getBalanceSheet().addToPay(payer, share);
            payer.getBalanceSheet().addToReceive(user, share);
        }
    }

    @Override
    public void print() {
        System.out.println("Expense Name: " + expenseName);
        System.out.println("Payer: " + payer.getName());
        System.out.println("Group: " + group.getGroupName());
        System.out.println("Amount: " + amount);
        System.out.println("Expense Strategy: " + expenseStrategy.getClass().getSimpleName());

        System.out.println("Split: ");
        for (Map.Entry<User, Double> entry : userMap.entrySet()) {
            User user = entry.getKey();
            double share = entry.getValue();
            System.out.println(user.getName() + ": " + share);
        }
    }
}
