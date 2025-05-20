package ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionManager {
    private List<Resource> freeResources;
    private List<Resource> inUseResources;
    private int maxConnections = 6;
    private int intialisedConnections;
    private static DBConnectionManager instance;

    private DBConnectionManager(int intialisedConnections) {
        this.intialisedConnections = intialisedConnections;
        this.freeResources = new ArrayList<>();
        this.inUseResources = new ArrayList<>();

        for (int i = 0; i < this.intialisedConnections; i++) {
            Resource resource = new Resource();
            freeResources.add(resource);
        }
    }

    public static DBConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DBConnectionManager.class) {
                if (instance == null) {
                    instance = new DBConnectionManager(3);
                }
            }
        }
        return instance;
    }

    public synchronized Resource getConnection() {
        if (freeResources.isEmpty()) {
            if (inUseResources.size() < maxConnections) {
                Resource resource = new Resource();
                inUseResources.add(resource);
                System.out.println("Assigning Resource | Resources in use: " + inUseResources.size());
                return resource;
            } else {
                System.out.println("Assigning Resource | No available connections");
                return null;
            }
        } else {
            Resource resource = freeResources.remove(freeResources.size() - 1);
            inUseResources.add(resource);
            System.out.println("Assigning Resource | Resources in use: " + inUseResources.size());
            return resource;
        }
    }

    public synchronized void releaseConnection(Resource resource) {
        if (resource == null) {
            return;
        }

        inUseResources.remove(resource);
        freeResources.add(resource);

        System.out.println("Removing Resource | Resources in use: " + inUseResources.size());
    }
}
