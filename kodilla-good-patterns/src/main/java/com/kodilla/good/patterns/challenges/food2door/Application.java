package com.kodilla.good.patterns.challenges.food2door;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        FoodOnlineStore foodOnlineStore = new FoodOnlineStore();
        Thread.sleep(1000);
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Product", 1, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Product", 2, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Product", 3, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Product", 4, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Andrew", "Product", 4, foodOnlineStore.getFoodSuppliers().get(0)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Pancakes", 2, foodOnlineStore.getFoodSuppliers().get(1)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Gluten Pancakes", 2, foodOnlineStore.getFoodSuppliers().get(1)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Apples", 2, foodOnlineStore.getFoodSuppliers().get(2)));
        foodOnlineStore.acceptNewOrder(new FoodOrder("Tom", "Healthy apples", 2, foodOnlineStore.getFoodSuppliers().get(2)));
    }

}
