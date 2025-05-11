package SplitWiseApplication;

public class User {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    BalanceSheet balanceSheet;

    public User(String userId, String name, String email, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balanceSheet = new BalanceSheet();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BalanceSheet getBalanceSheet() {
        return this.balanceSheet;
    }

    public String getUserId() {
        return userId;
    }

    public String toString() {
        return "User ID: " + userId + "\t" +
               "Name: " + name + "\t" +
               "Email: " + email + "\t" +
               "Phone Number: " + phoneNumber;
    }
}
