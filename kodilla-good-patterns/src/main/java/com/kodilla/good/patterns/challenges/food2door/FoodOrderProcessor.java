package com.kodilla.good.patterns.challenges.food2door;

public class FoodOrderProcessor implements OrderProcessor{

    private MessageService messageService;
    private FoodOnlineStore foodOnlineStore;

    public FoodOrderProcessor(MessageService messageService, FoodOnlineStore foodOnlineStore) {
        this.messageService = messageService;
        this.foodOnlineStore = foodOnlineStore;
    }

    @Override
    public FoodOrderDto processOrder(FoodOrder foodOrder) {

        FoodSupplier foodSupplier = foodOrder.getFoodSupplier();
        String customer = foodOrder.getCustomer();
        String productName = foodOrder.getProductName();
        int productQuantity = foodOrder.getQuantity();
        boolean orderProcessedSuccessfully;
        String message;

        if(!foodOnlineStore.getFoodSuppliers().contains(foodSupplier)) {
            orderProcessedSuccessfully = false;
            message = "Food supplier not found, cannot process order.";
        } else {
            FoodSupplierFeedbackDto feedbackDto = foodSupplier.processOrder(foodOrder.getCustomer(), foodOrder.getProductName(),
                    foodOrder.getQuantity());
            orderProcessedSuccessfully = feedbackDto.isOrderProcessedSuccessfully();
            message = feedbackDto.getMessage();
        }

        return new FoodOrderDto(customer, productName, productQuantity, foodSupplier, orderProcessedSuccessfully, message);
    }

}
