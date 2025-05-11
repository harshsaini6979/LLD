package SplitWiseApplication.ExpenseStrategy;

import SplitWiseApplication.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements ExpenseStrategy {
    @Override
    public Map<User, Double> compute(User payer, double amount, List<User> users) {
        int numUsers = users.size();

        Map<User, Double> userMap = new HashMap<>();

        for(User user : users) {
            double share = amount / numUsers;

            if (!payer.getName().equals(user.getName()))
                userMap.put(user, share);
            else
                userMap.put(user, 0.0);
        }

        return userMap;
    }
}
