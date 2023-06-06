package ProxyDesignPattern;

public class EmployeeImpl implements Employee{
    @Override
    public void create(String client)  throws Exception{
        System.out.println("Create function executed!!");
    }

    @Override
    public void delete(String client)  throws Exception{
        System.out.println("Delete function executed!!");
    }

    @Override
    public void get(String client)  throws Exception{
        System.out.println("Get function executed!!");
    }
}
