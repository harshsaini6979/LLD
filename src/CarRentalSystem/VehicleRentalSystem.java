package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    public VehicleRentalSystem(List<Store> storeList, List<User> userList) {
        this.storeList = storeList;
        this.userList = userList;
    }

    public List<Store> getStore(Location location) {
        List<Store> list = new ArrayList<>();

        for (Store s : storeList) {
            if (s.getStoreLocation().city == location.city)
                list.add(s);
        }
        return list;
    }
}
