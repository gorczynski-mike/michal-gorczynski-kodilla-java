package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop extends GenericFoodSupplier {

    public ExtraFoodShop() {
        super("Extra Food Shop", 101);
    }

    @Override
    public FoodOrderFeedbackDto processOrder(FoodOrderDto foodOrderDto) {
        return new FoodOrderFeedbackDto(foodOrderDto, true);
    }

}
