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

        senMessage("Processing order: " + foodOrder);
        if (!foodOnlineStore.getFoodSuppliers().contains(foodSupplier)) {
            sendFeedbackInfo(false, foodOrder, "No such supplier", FoodOrderReturnCode.NO_SUCH_SUPPLIER);
            return false;
        } else {
            FoodOrderFeedbackDto foodOrderFeedbackDto = foodSupplier.processOrder(foodOrderDto);
            boolean isOrderProcessedOk = foodOrderFeedbackDto.isOrderProcessedSuccessfully();
            sendFeedbackInfo(isOrderProcessedOk,
                    foodOrder,
                    foodOrderFeedbackDto.getMessage(),
                    foodOrderFeedbackDto.getReturnCode());
            return isOrderProcessedOk;
        }
    }

    private void sendFeedbackInfo(boolean processedOK, FoodOrder foodOrder, String message, FoodOrderReturnCode returnCode) {
        if(processedOK) {
            senMessage("Order: " + foodOrder + " was processed successfully.");
        } else {
            senMessage("Order: " + foodOrder + " was rejected.");
        }
        if (message != null && !message.equals("")) {
            senMessage("Return message: " + message);
        }
        if (returnCode != null && !returnCode.equals(FoodOrderReturnCode.NULL)) {
            senMessage("Return code: " + returnCode);
        }
    }

    private void senMessage(String message) {
        messageService.acceptMessage("ORDER PROCESSOR INFO: " + message);
    }

}
