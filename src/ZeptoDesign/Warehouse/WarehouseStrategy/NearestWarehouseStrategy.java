package ZeptoDesign.Warehouse.WarehouseStrategy;

import ZeptoDesign.Address;
import ZeptoDesign.Product.Product;
import ZeptoDesign.Warehouse.Warehouse;

import java.util.List;
import java.util.Map;

public class NearestWarehouseStrategy implements WarehouseStrategy {

    public Warehouse getWarehouse(List<Warehouse> warehouseList, Address address, Map<Integer, Integer> productList) {
        Warehouse resultWarehouse = null;
        int minDistance = Integer.MAX_VALUE;

        for (Warehouse warehouse : warehouseList) {

            if (!isPossible(warehouse, productList)) {
                continue;
            }

            int distance = Math.abs(warehouse.getAddress().getZipCode() - address.getZipCode());
            if (distance < minDistance) {
                minDistance = distance;
                resultWarehouse = warehouse;
            }
        }

        return resultWarehouse;
    }

    private boolean isPossible(Warehouse warehouse, Map<Integer, Integer> productList) {
        Map<Integer, Product> allProducts = warehouse.getAllProducts();

        for (Map.Entry<Integer, Integer> entry : productList.entrySet()) {
            int productId = entry.getKey();
            int requiredQuantity = entry.getValue();

            if (!allProducts.containsKey(productId)) {
                return false;
            }

            Product product = allProducts.get(productId);

            if (product.getProductQuantity() < requiredQuantity) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.println("Order will be delivered in 5 working days");
    }
}
