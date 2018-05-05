package com.kodilla.good.patterns.challenges.food2door;

public interface FoodSupplier {

    FoodSupplierFeedbackDto processOrder(String customer, String productName, int quantity);

}
