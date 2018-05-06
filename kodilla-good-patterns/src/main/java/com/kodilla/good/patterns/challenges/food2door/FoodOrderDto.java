package com.kodilla.good.patterns.challenges.food2door;

public class FoodOrderDto {

    private final String customer;
    private final String productName;
    private final int quantity;

    public FoodOrderDto(FoodOrder foodOrder) {
        this.customer = foodOrder.getCustomer();
        this.productName = foodOrder.getProductName();
        this.quantity = foodOrder.getQuantity();
    }

    public FoodOrderDto(String customer, String productName, int quantity, FoodSupplier foodSupplier) {
        this.customer = customer;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

}
