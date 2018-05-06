package com.kodilla.good.patterns.challenges.food2door;

public class FoodOrderProcessor implements OrderProcessor{

    private MessageService messageService;
    private FoodOnlineStore foodOnlineStore;

    public FoodOrderProcessor(MessageService messageService, FoodOnlineStore foodOnlineStore) {
        this.messageService = messageService;
        this.foodOnlineStore = foodOnlineStore;
    }

    @Override
    public FoodOrderFeedbackDto processOrder(FoodOrder foodOrder) {

        FoodSupplier foodSupplier = foodOrder.getFoodSupplier();
        FoodOrderDto foodOrderDto = new FoodOrderDto(foodOrder);

        if(!foodOnlineStore.getFoodSuppliers().contains(foodSupplier)) {
            return new FoodOrderFeedbackDto(foodOrderDto, false, "No such supplier",
                    FoodOrderReturnCode.NO_SUCH_SUPPLIER);
        } else {
            return foodSupplier.processOrder(foodOrderDto);
        }
    }

}
