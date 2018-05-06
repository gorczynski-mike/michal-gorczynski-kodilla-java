package com.kodilla.good.patterns.challenges.food2door;

import java.util.Map;

/**
 * Gluten free shop will reject any order with product name containing word "gluten"
 */
public class GlutenFreeShop extends GenericFoodSupplier {

    public GlutenFreeShop() {
        super("Gluten Free Shop");
    }

    @Override
    public FoodOrderFeedbackDto processOrder(FoodOrderDto foodOrderDto) {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String productName = foodOrderDto.getProductName();
        Map<Integer, FoodOrderReturnCode> returnCodes = foodOrderDto.getReturnCodes();
        if(productName.toLowerCase().contains("gluten")) {
            return  new FoodOrderFeedbackDto(false, "We do not supply gluten products.",
                    returnCodes.get(203));
        } else {
            return new FoodOrderFeedbackDto(true);
        }
    }
}
