package com.kodilla.good.patterns.challenges.food2door;

import java.util.Objects;

public abstract class GenericFoodSupplier implements  FoodSupplier {

    final String foodSupplierName;
    final int foodSupplierId;

    public GenericFoodSupplier(String foodSupplierName, int foodSupplierId) {
        this.foodSupplierName = foodSupplierName;
        this.foodSupplierId = foodSupplierId;
    }

    @Override
    public String toString() {
        return "FoodSupplier{" +
                "foodSupplierName='" + foodSupplierName + '\'' +
                ", foodSupplierId=" + foodSupplierId +
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
