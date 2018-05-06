package com.kodilla.good.patterns.challenges.food2door;

/**
 * Similar to FoodOrderDto but it is intended to use within application only. Do not use it to communicate with
 * FoodSuppliers.
 */
public class FoodOrder {

    private final String customer;
    private final String productName;
    private final int quantity;
    private final FoodSupplier foodSupplier;

    public FoodOrder(String customer, String productName, int quantity, FoodSupplier foodSupplier) {
        this.customer = customer;
        this.productName = productName;
        this.quantity = quantity;
        this.foodSupplier = foodSupplier;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public FoodSupplier getFoodSupplier() {
        return foodSupplier;
    }

    public String getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "FoodOrder{" + quantity + " of '" + productName + "' to '" + customer + "' from " + foodSupplier + "}";
    }
}
