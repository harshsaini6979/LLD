package ZeptoDesign.Warehouse.WarehouseStrategy;

import ZeptoDesign.Address;
import ZeptoDesign.Warehouse.Warehouse;

import java.util.List;
import java.util.Map;

public interface WarehouseStrategy {
    Warehouse getWarehouse(List<Warehouse> warehouseList, Address address, Map<Integer, Integer> productList);
    void print();
}
