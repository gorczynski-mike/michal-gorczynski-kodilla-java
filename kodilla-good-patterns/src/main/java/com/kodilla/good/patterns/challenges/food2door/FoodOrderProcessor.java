package com.kodilla.good.patterns.challenges.food2door;

public class FoodOrderProcessor implements OrderProcessor{

    private MessageService messageService;
    private FoodOnlineStore foodOnlineStore;

    public FoodOrderProcessor(MessageService messageService, FoodOnlineStore foodOnlineStore) {
        this.messageService = messageService;
        this.foodOnlineStore = foodOnlineStore;
    }

    @Override
    public boolean processOrder(FoodOrder foodOrder) {

        FoodSupplier foodSupplier = foodOrder.getFoodSupplier();
        FoodOrderDto foodOrderDto = new FoodOrderDto(foodOrder);

        if(!foodOnlineStore.getFoodSuppliers().contains(foodSupplier)) {
            sendInfoOrderRejected(foodOrder, "No such supplier", FoodOrderReturnCode.NO_SUCH_SUPPLIER);
            return false;
        } else {
            FoodOrderFeedbackDto foodOrderFeedbackDto = foodSupplier.processOrder(foodOrderDto);
            if(foodOrderFeedbackDto.isOrderProcessedSuccessfully()) {
                sendInfoOrderAccepted(foodOrder);
                return true;
            } else {
                sendInfoOrderRejected(foodOrder, foodOrderFeedbackDto.getMessage(), foodOrderFeedbackDto.getReturnCode());
                return false;
            }
        }
    }

    private void sendInfoOrderAccepted(FoodOrder foodOrder) {
        messageService.acceptMessage("Order: " + foodOrder + " was processed successfully.");
    }

    private void sendInfoOrderRejected(FoodOrder foodOrder, String message, FoodOrderReturnCode returnCode) {
        messageService.acceptMessage("Order: " + foodOrder + " was rejected.");
        messageService.acceptMessage("Rejection message: " + message);
        messageService.acceptMessage("Rejection code: " + returnCode);
    }

}
