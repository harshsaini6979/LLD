package ObjectPoolDesignPattern;

public class Main {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = DBConnectionManager.getInstance();

        Resource resource1 = dbConnectionManager.getConnection();
        Resource resource2 = dbConnectionManager.getConnection();
        Resource resource3 = dbConnectionManager.getConnection();
        Resource resource4 = dbConnectionManager.getConnection();
        Resource resource5 = dbConnectionManager.getConnection();
        Resource resource6 = dbConnectionManager.getConnection();
        Resource resource7 = dbConnectionManager.getConnection();

        dbConnectionManager.releaseConnection(resource1);

        Resource resource8 = dbConnectionManager.getConnection();
    }
}
