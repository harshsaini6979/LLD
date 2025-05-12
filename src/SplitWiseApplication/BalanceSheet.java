package SplitWiseApplication;

import SplitWiseApplication.Expense.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet {
    Map<User, Double> toPay;
    Map<User, Double> toReceive;
    List<Expense> expenses;

    public BalanceSheet() {
        this.toPay = new HashMap<>();
        this.toReceive = new HashMap<>();
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    public void addToPay(User user, double amount) {
        double toReceiveAmount = toReceive.getOrDefault(user, 0.0);
        double toPayAmount = toPay.getOrDefault(user, 0.0) + amount;

        toPay.put(user, toPayAmount);

        if (toReceiveAmount>=toPayAmount) {
            toReceive.put(user, toReceiveAmount - toPayAmount);
            toPay.put(user, 0.0);
        } else {
            toPay.put(user, toPayAmount - toReceiveAmount);
            toReceive.put(user, 0.0);
        }
    }

    public void addToReceive(User user, double amount) {
        double toReceiveAmount = toReceive.getOrDefault(user, 0.0) + amount;
        double toPayAmount = toPay.getOrDefault(user, 0.0);

        toPay.put(user, toPayAmount);

        if (toReceiveAmount>=toPayAmount) {
            toReceive.put(user, toReceiveAmount - toPayAmount);
            toPay.put(user, 0.0);
        } else {
            toPay.put(user, toPayAmount - toReceiveAmount);
            toReceive.put(user, 0.0);
        }
    }

    public void printBalanceSheet() {
        System.out.println("To Pay:");
        for(Map.Entry<User, Double> entry : toPay.entrySet()) {
            if (entry.getValue() == 0.0) continue;
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
        System.out.print("Total to Pay: " + totalToPay() + "\n");

        System.out.println("To Receive:");
        for(Map.Entry<User, Double> entry : toReceive.entrySet()) {
            if (entry.getValue() == 0.0) continue;
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
        System.out.print("Total to Receive: " + totalToReceive() + "\n");
    }

    public double totalToPay() {
        double total = 0;
        for (double amount : toPay.values()) {
            total += amount;
        }
        return total;
    }

    public double totalToReceive() {
        double total = 0;
        for (double amount : toReceive.values()) {
            total += amount;
        }
        return total;
    }

    public void printExpenses() {
        for (Expense expense : expenses) {
            expense.print();
        }
    }
}
