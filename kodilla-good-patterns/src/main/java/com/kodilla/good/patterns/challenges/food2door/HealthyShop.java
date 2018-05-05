package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop extends GenericFoodSupplier {

    public HealthyShop() {
        super("Healthy Shop", 102);
    }

    @Override
    public FoodSupplierFeedbackDto processOrder(String customer, String productName, int quantity) {
        return new FoodSupplierFeedbackDto(true, "");
    }
}
