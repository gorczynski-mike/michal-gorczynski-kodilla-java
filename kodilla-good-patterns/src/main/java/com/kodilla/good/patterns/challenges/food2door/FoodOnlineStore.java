package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.Queue;

public class FoodOnlineStore {

    private final OrderProcessor foodOrderProcessor = new FoodOrderProcessor();
    private final Queue<FoodOrder> todayFoodOrders = new LinkedList<>();
    private boolean isOperating = true;

    public FoodOnlineStore() {
        Thread foodOnlineStoreThread = new Thread(() -> {
            System.out.println("Food online store is now operating and waiting to process orders.");
            while(isOperating) {
                if (!todayFoodOrders.isEmpty()) {
                    foodOrderProcessor.processOrder(todayFoodOrders.poll());
                } else {
                    System.out.println("No orders to process. Idle.");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Orders waiting in queue: " + todayFoodOrders.size());
            }
            while(!todayFoodOrders.isEmpty()) {
                foodOrderProcessor.processOrder(todayFoodOrders.poll());
                System.out.println("Orders waiting in queue: " + todayFoodOrders.size());
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Closing business. See you tomorrow!");
        });
        foodOnlineStoreThread.start();
    }

    public boolean acceptNewOrder(FoodOrder foodOrder) {
        if (isOperating) {
            return todayFoodOrders.offer(foodOrder);
        } else {
            System.out.println("Sorry, business is closing and not accepting new orders. Place your order tomorrow.");
            return false;
        }
    }

    public void stopOperating() {
        this.isOperating = false;
        System.out.println("Business is closing, it will not accept any more orders today. You can place orders tomorrow.");
    }

}
