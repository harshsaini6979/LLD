package SplitWiseApplication.ExpenseStrategy;

import SplitWiseApplication.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UnEqualSplit implements ExpenseStrategy {
    @Override
    public Map<User, Double> compute(User payer, double amount, List<User> users) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);

        Map<User, Double> userMap = new HashMap<>();

        double totalAmount = 0;

        for (User user : users) {
            System.out.println("Enter the amount for " + user.getName() + ": ");
            double share = scanner.nextDouble();
            userMap.put(user, share);
            totalAmount += share;

            if (!payer.getUserId().equals(user.getUserId()))
                userMap.put(user, share);
            else
                userMap.put(user, 0.0);
        }

        if (amount != totalAmount)
            throw new IllegalArgumentException("Total amount does not match the sum of user shares.");

        return userMap;
    }
}
