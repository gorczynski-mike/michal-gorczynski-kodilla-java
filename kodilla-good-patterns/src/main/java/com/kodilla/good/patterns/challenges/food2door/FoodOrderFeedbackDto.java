package com.kodilla.good.patterns.challenges.food2door;

public class FoodOrderFeedbackDto {

    private final boolean orderProcessedSuccessfully;
    private final String message;
    private final FoodOrderReturnCode returnCode;

    public FoodOrderFeedbackDto(boolean orderProcessedSuccessfully, String message, FoodOrderReturnCode returnCode) {
        this.orderProcessedSuccessfully = orderProcessedSuccessfully;
        this.message = message;
        this.returnCode = returnCode;
    }

    public FoodOrderFeedbackDto(boolean orderProcessedSuccessfully) {
        this(orderProcessedSuccessfully, "", FoodOrderReturnCode.NULL);
    }

    public FoodOrderFeedbackDto(boolean orderProcessedSuccessfully, String message) {
        this(orderProcessedSuccessfully, message, FoodOrderReturnCode.NULL);
    }

    public boolean isOrderProcessedSuccessfully() {
        return orderProcessedSuccessfully;
    }

    public String getMessage() {
        return message;
    }

    public FoodOrderReturnCode getReturnCode() {
        return returnCode;
    }
}
