package com.kodilla.good.patterns.challenges;

public class WarehouseOrderService implements OrderService{

    private final WarehouseService warehouseService;

    public WarehouseOrderService(final WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Override
    public boolean order(User user, Product product, int quantity) {
        if(warehouseService.isInStock(product,quantity)) {
            return warehouseService.sendProducts(user,product,quantity);
        } else {
            System.out.println("Not enough products in stock to complete order.");
            return false;
        }
    }
}
