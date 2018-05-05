package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop extends GenericFoodSupplier {

    public ExtraFoodShop() {
        super("Extra Food Shop", 101);
    }

    @Override
    public FoodSupplierFeedbackDto processOrder(String customer, String productName, int quantity) {
        return new FoodSupplierFeedbackDto(true, "");
    }

}
