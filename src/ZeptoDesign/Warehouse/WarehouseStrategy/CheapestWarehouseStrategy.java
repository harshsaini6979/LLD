package ZeptoDesign.Warehouse.WarehouseStrategy;

import ZeptoDesign.Address;
import ZeptoDesign.Product.Product;
import ZeptoDesign.Warehouse.Warehouse;

import java.util.List;
import java.util.Map;

public class CheapestWarehouseStrategy implements WarehouseStrategy{

    public Warehouse getWarehouse(List<Warehouse> warehouseList, Address address, Map<Integer, Integer> productList) {
        Warehouse resultWarehouse = null;
        int minAmount = Integer.MAX_VALUE;

        for (Warehouse warehouse : warehouseList) {
            int amount = isPossible(warehouse, productList);
            if (amount == 0) {
                continue;
            }

            if (amount < minAmount) {
                minAmount = amount;
                resultWarehouse = warehouse;
            }
        }

        return resultWarehouse;
    }

    private int isPossible(Warehouse warehouse, Map<Integer, Integer> productList) {
        Map<Integer, Product> allProducts = warehouse.getAllProducts();
        int currAmount = 0;

        for (Map.Entry<Integer, Integer> entry : productList.entrySet()) {
            int productId = entry.getKey();
            int requiredQuantity = entry.getValue();

            if (!allProducts.containsKey(productId)) {
                return 0;
            }

            Product product = allProducts.get(productId);

            if (product.getProductQuantity() < requiredQuantity) {
                return 0;
            }

            currAmount += warehouse.totalAmount(productId, requiredQuantity);
        }
        return currAmount;
    }

    public void print() {
        System.out.println("Order will be delivered in 5 working days");
    }
}
