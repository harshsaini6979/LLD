package SplitWiseApplication.ExpenseStrategy;

import SplitWiseApplication.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PercentageSplit implements ExpenseStrategy {
    @Override
    public Map<User, Double> compute(User payer, double amount, List<User> users) throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        Map<User, Double> userMap = new HashMap<>();

        double totalPercentage = 0;
        for (User user : users) {
            System.out.println("Enter percentage for " + user.getName() + ": ");
            double percentage = scanner.nextDouble();
            if (percentage < 0 || percentage > 100) {
                throw new IllegalArgumentException("Percentage must be between 0 and 100");
            }
            userMap.put(user, percentage);

            totalPercentage += percentage;

            double share = (percentage / 100) * amount;
            if (!payer.getUserId().equals(user.getUserId()))
                userMap.put(user, share);
            else
                userMap.put(user, 0.0);

        }

        if(totalPercentage != 100) {
            throw new IllegalArgumentException("Total percentage must be 100");
        }

        return userMap;
    }
}
