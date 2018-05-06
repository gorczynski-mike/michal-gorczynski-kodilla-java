package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop extends GenericFoodSupplier {

    public GlutenFreeShop() {
        super("Gluten Free Shop");
    }

    @Override
    public FoodOrderFeedbackDto processOrder(FoodOrderDto foodOrderDto) {
        return new FoodOrderFeedbackDto(true);
    }
}
