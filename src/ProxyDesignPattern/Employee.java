package ProxyDesignPattern;

public interface Employee {
    public void create(String client) throws Exception;
    public void delete(String client) throws Exception;
    public void get(String client) throws Exception;
}
