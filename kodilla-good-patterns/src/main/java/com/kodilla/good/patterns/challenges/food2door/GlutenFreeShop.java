package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop extends GenericFoodSupplier {

    public GlutenFreeShop() {
        super("Gluten Free Shop", 100);
    }

    @Override
    public FoodSupplierFeedbackDto processOrder(String customer, String productName, int quantity) {
        return new FoodSupplierFeedbackDto(true, "");
    }
}
