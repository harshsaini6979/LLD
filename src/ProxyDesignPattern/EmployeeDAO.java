package ProxyDesignPattern;

public class EmployeeDAO implements Employee {
    Employee employee;
    public EmployeeDAO() {
        employee = new EmployeeImpl();
    }

    @Override
    public void create(String client)  throws Exception {
        if (client.equals("ADMIN")) {
            employee.create(client);
        }
        else {
            throw new Exception("CREATE - Error");
        }
    }

    @Override
    public void delete(String client)  throws Exception {
        if (client.equals("ADMIN")) {
            employee.delete(client);
        }
        else {
            throw new Exception("DELETE - Error");
        }
    }

    @Override
    public void get(String client)  throws Exception {
        if (client.equals("ADMIN") || client.equals("USER")) {
            employee.get(client);
        }
        else {
            throw new Exception("GET - Error");
        }
    }
}
