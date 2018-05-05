package com.kodilla.good.patterns.challenges.food2door;

public class FoodOrderDto {

    private final String customer;
    private final String productName;
    private final int quantity;
    private final FoodSupplier foodSupplier;
    private final boolean isProcessedSuccessfully;
    private String message;

    public FoodOrderDto(String customer, String productName, int quantity, FoodSupplier foodSupplier, boolean isProcessedSuccessfully) {
        this.customer = customer;
        this.productName = productName;
        this.quantity = quantity;
        this.foodSupplier = foodSupplier;
        this.isProcessedSuccessfully = isProcessedSuccessfully;
        this.message = null;
    }

    public FoodOrderDto(String customer, String productName, int quantity, FoodSupplier foodSupplier, boolean isProcessedSuccessfully, String rejectionReason) {
        this(customer, productName, quantity, foodSupplier, isProcessedSuccessfully);
        this.message = rejectionReason;
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

    public FoodSupplier getFoodSupplier() {
        return foodSupplier;
    }

    public boolean isProcessedSuccessfully() {
        return isProcessedSuccessfully;
    }

    public String getMessage() {
        return message;
    }
}
