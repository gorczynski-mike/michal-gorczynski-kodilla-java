package com.kodilla.good.patterns.challenges.food2door;

/**
 * Healthy shop will only accept orders containing word "healthy"
 */
public class HealthyShop extends GenericFoodSupplier {

    public HealthyShop() {
        super("Healthy Shop");
    }

    @Override
    public FoodOrderFeedbackDto processOrder(FoodOrderDto foodOrderDto) {
        try {
            Thread.sleep(2200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String productName = foodOrderDto.getProductName();
        if(!productName.toLowerCase().contains("healthy")) {
            return new FoodOrderFeedbackDto(false, "We supply only healthy products.",
                    foodOrderDto.getReturnCodes().get(202));
        } else {
            return new FoodOrderFeedbackDto(true, "Order processed ok",
                    foodOrderDto.getReturnCodes().get(1));
        }
    }
}
