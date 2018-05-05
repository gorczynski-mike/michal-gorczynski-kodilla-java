package com.kodilla.good.patterns.challenges.food2door;

public class FoodSupplierFeedbackDto {

    private final boolean orderProcessedSuccessfully;
    private final String message;
    private final FoodOrderRejectionReason rejectionReason;

    public FoodSupplierFeedbackDto(boolean orderProcessedSuccessfully, String message, FoodOrderRejectionReason rejectionReason) {
        this.orderProcessedSuccessfully = orderProcessedSuccessfully;
        this.message = message;
        this.rejectionReason = rejectionReason;
    }

    public FoodSupplierFeedbackDto(boolean orderProcessedSuccessfully, String message) {
        this.orderProcessedSuccessfully = orderProcessedSuccessfully;
        this.message = message;
        this.rejectionReason = FoodOrderRejectionReason.NULL;
    }

    public boolean isOrderProcessedSuccessfully() {
        return orderProcessedSuccessfully;
    }

    public String getMessage() {
        return message;
    }
}
