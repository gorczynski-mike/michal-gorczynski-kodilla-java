package com.kodilla.good.patterns.challenges.food2door;

/**
 * Even food shop will only accept orders of even quantities. Also, it wouldn't ship any products to Andrew,
 * we don't know why.
 */
public class EvenFoodShop extends GenericFoodSupplier {

    public EvenFoodShop() {
        super("Even Food Shop");
    }

    @Override
    public FoodOrderFeedbackDto processOrder(FoodOrderDto foodOrderDto) {
        try {
            Thread.sleep(1700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int productQuantity = foodOrderDto.getQuantity();
        String customer = foodOrderDto.getCustomer();
        if(customer.toLowerCase().equalsIgnoreCase("Andrew")) {
            return new FoodOrderFeedbackDto(false, "After some saddening events in the past" +
                    " we no longer ship to Andrew.",
                    foodOrderDto.getReturnCodes().get(301));
        } else if(!(productQuantity % 2 == 0)) {
            return new FoodOrderFeedbackDto(false, "We only supply even quantities.",
                    foodOrderDto.getReturnCodes().get(202));
        } else {
            return new FoodOrderFeedbackDto(true, "Order processed ok",
                    foodOrderDto.getReturnCodes().get(1));
        }
    }

}
