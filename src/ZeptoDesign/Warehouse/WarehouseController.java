package ZeptoDesign.Warehouse;

import ZeptoDesign.Address;
import ZeptoDesign.Product.Product;
import ZeptoDesign.Warehouse.WarehouseStrategy.WarehouseStrategy;

import java.util.List;
import java.util.Map;

public class WarehouseController {
    Map<Integer, Warehouse> warehouseMap;

    public WarehouseController(Map<Integer, Warehouse> warehouseMap) {
        this.warehouseMap = warehouseMap;
    }

    public void addProduct(int warehouseId, Product product) {
        Warehouse warehouse = warehouseMap.get(warehouseId);
        if (warehouse != null) {
            warehouse.addProduct(product);
        }
    }

    public void removeProduct(int warehouseId, int productId) {
        Warehouse warehouse = warehouseMap.get(warehouseId);
        if (warehouse != null) {
            warehouse.removeProduct(productId);
        }
    }

    public boolean addWarehouse(Warehouse warehouse) {
        if (warehouseMap.containsKey(warehouse.getWareHouseId())) {
            System.out.println("Warehouse already exists");
            return false;
        }

        warehouseMap.put(warehouse.getWareHouseId(), warehouse);
        System.out.println("Warehouse added successfully");
        return true;
    }

    public void updateProduct(int warehouseId, int productId, int count) {
        Warehouse warehouse = warehouseMap.get(warehouseId);
        if (warehouse != null) {
            warehouse.updateProduct(productId, count);
        }
    }

    public List<Warehouse> getAllWarehouses() {
        return List.copyOf(warehouseMap.values());
    }

    public int buyProduct(Map<Integer, Integer> product, WarehouseStrategy warehouseStrategy, Address address) {
        Warehouse warehouse = warehouseStrategy.getWarehouse(getAllWarehouses(), address, product);

        if (warehouse == null) {
            return 0;
        }

        int totalAmount = 0;

        for (Map.Entry<Integer, Integer> entry : product.entrySet()) {
            int productId = entry.getKey();
            int requiredQuantity = entry.getValue();

            totalAmount += warehouse.totalAmount(productId, requiredQuantity);

            updateProduct(warehouse.getWareHouseId(), productId, -requiredQuantity);
        }

        return totalAmount;
    }

    public Warehouse getWarehouse(int warehouseId) {
        return warehouseMap.get(warehouseId);
    }
}
