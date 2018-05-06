package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop extends GenericFoodSupplier {

    public HealthyShop() {
        super("Healthy Shop", 102);
    }

    @Override
    public FoodOrderFeedbackDto processOrder(FoodOrderDto foodOrderDto) {
        return new FoodOrderFeedbackDto(foodOrderDto, true);
    }
}
