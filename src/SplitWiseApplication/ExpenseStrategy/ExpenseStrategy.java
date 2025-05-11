package SplitWiseApplication.ExpenseStrategy;

import SplitWiseApplication.User;

import java.util.List;
import java.util.Map;

public interface ExpenseStrategy {
    public Map<User, Double> compute(User payer, double amount, List<User> users);
}
