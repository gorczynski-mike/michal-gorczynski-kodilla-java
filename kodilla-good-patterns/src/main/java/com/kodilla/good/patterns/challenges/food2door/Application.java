package com.kodilla.good.patterns.challenges.food2door;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        FoodOnlineStore foodOnlineStore = new FoodOnlineStore();
        Thread.sleep(1000);
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        Thread.sleep(4500);
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Customer", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
    }

}
