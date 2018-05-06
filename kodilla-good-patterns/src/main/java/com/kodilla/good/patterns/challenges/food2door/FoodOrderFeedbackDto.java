package com.kodilla.good.patterns.challenges.food2door;

public class FoodOrderFeedbackDto {

    private final boolean orderProcessedSuccessfully;
    private final String message;
    private final FoodOrderReturnCode returnCode;
    private final FoodOrderDto foodOrderDto;

    public FoodOrderFeedbackDto(FoodOrderDto foodOrderDto, boolean orderProcessedSuccessfully, String message, FoodOrderReturnCode returnCode) {
        this.foodOrderDto = foodOrderDto;
        this.orderProcessedSuccessfully = orderProcessedSuccessfully;
        this.message = message;
        this.returnCode = returnCode;
    }

    public FoodOrderFeedbackDto(FoodOrderDto foodOrderDto, boolean orderProcessedSuccessfully) {
        this(foodOrderDto, orderProcessedSuccessfully, "", FoodOrderReturnCode.NULL);
    }

    public FoodOrderFeedbackDto(FoodOrderDto foodOrderDto, boolean orderProcessedSuccessfully, String message) {
        this(foodOrderDto, orderProcessedSuccessfully, message, FoodOrderReturnCode.NULL);
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
