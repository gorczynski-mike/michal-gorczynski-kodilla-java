package com.kodilla.good.patterns.challenges.food2door;

import java.util.Objects;

/**
 * Every FoodSupplier must extend this class. To create a new store you must provide its name and override
 * FoodSupplier interface method: FoodOrderFeedbackDto processOrder(FoodOrderDto foodOrderDto);
 * Every food supplier can use our FoodOrderReturnCodes in the feedback object - list of codes and their meaning
 * will be emailed to store after it's requested.
 */
public abstract class GenericFoodSupplier implements FoodSupplier {

    private static int nextFoodSupplierId = 100;

    final String foodSupplierName;
    final int foodSupplierId;

    public GenericFoodSupplier(String foodSupplierName) {
        this.foodSupplierName = foodSupplierName;
        this.foodSupplierId = nextFoodSupplierId++;
    }

    @Override
    public String toString() {
        return "FoodSupplier{" +
                foodSupplierName +
                ", Id=" + foodSupplierId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericFoodSupplier that = (GenericFoodSupplier) o;
        return foodSupplierId == that.foodSupplierId &&
                Objects.equals(foodSupplierName, that.foodSupplierName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(foodSupplierName, foodSupplierId);
    }

    public String getFoodSupplierName() {
        return foodSupplierName;
    }

    public int getFoodSupplierId() {
        return foodSupplierId;
    }
}
