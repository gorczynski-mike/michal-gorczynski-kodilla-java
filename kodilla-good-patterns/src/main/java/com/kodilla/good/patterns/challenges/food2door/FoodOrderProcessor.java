package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;

public class FoodOrderProcessor implements OrderProcessor{

    List<FoodSupplier> suppliers = new ArrayList<>();

    {

    }

    @Override
    public FoodOrderDto processOrder(FoodOrder foodOrder) {
        return null;
    }
}
