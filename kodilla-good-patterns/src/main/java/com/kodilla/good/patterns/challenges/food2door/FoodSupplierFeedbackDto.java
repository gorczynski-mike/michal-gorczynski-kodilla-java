package com.kodilla.good.patterns.challenges.food2door;

public class FoodSupplierFeedbackDto {

    private final boolean orderProcessedSuccessfully;
    private final String message;
    private final FoodOrderReturnCode returnCode;

    public FoodSupplierFeedbackDto(boolean orderProcessedSuccessfully, String message, FoodOrderReturnCode returnCode) {
        this.orderProcessedSuccessfully = orderProcessedSuccessfully;
        this.message = message;
        this.returnCode = returnCode;
    }

    public FoodSupplierFeedbackDto(boolean orderProcessedSuccessfully, String message) {
        this.orderProcessedSuccessfully = orderProcessedSuccessfully;
        this.message = message;
        this.returnCode = FoodOrderReturnCode.NULL;
    }

    public boolean isOrderProcessedSuccessfully() {
        return orderProcessedSuccessfully;
    }

    public String getMessage() {
        return message;
    }
}
