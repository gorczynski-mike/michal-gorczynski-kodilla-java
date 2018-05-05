package com.kodilla.good.patterns.challenges.food2door;

public class FoodSupplierFeedbackDto {

    private final boolean orderProcessedSuccessfully;
    private final String message;

    public FoodSupplierFeedbackDto(boolean orderProcessedSuccessfully, String message) {
        this.orderProcessedSuccessfully = orderProcessedSuccessfully;
        this.message = message;
    }

    public boolean isOrderProcessedSuccessfully() {
        return orderProcessedSuccessfully;
    }

    public String getMessage() {
        return message;
    }
}
