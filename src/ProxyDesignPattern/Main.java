package ProxyDesignPattern;

public class Main {
    public static void main(String args[]) {
        Employee employee = new EmployeeDAO();

        try {
            employee.create("ADMIN");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            employee.create("USER");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            employee.get("ADMIN");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            employee.get("USER2");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
