package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;

public class FoodOrderProcessor implements OrderProcessor{

    private MessageService messageService;

    public FoodOrderProcessor(MessageService messageService) {
        this.messageService = messageService;
    }

    List<FoodSupplier> suppliers = new ArrayList<>();

    {

    }

    @Override
    public FoodOrderDto processOrder(FoodOrder foodOrder) {
        return null;
    }
}
