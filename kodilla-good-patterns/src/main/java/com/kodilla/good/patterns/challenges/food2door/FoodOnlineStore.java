package com.kodilla.good.patterns.challenges.food2door;

import java.util.LinkedList;
import java.util.Queue;

public class FoodOnlineStore {

    private static final int MAX_ORDER_QUEUE_SIZE = 10;

    private final Queue<FoodOrder> todayFoodOrders = new LinkedList<>();
    UserInterface userInterface = new UserInterface(this);
    MessageService messageService = userInterface;
    private final OrderProcessor foodOrderProcessor = new FoodOrderProcessor(userInterface);
    private boolean isOperating = true;

    public FoodOnlineStore() {
        Thread foodOnlineStoreThread = new Thread(() -> {
            sendMessage("Food online store is now operating and waiting to process orders.");
            while(isOperating) {
                if (!todayFoodOrders.isEmpty()) {
                    foodOrderProcessor.processOrder(todayFoodOrders.poll());
                } else {
                    sendMessage("No orders to process. Idle.");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendMessage("Orders waiting in queue: " + todayFoodOrders.size());
            }
            while(!todayFoodOrders.isEmpty()) {
                foodOrderProcessor.processOrder(todayFoodOrders.poll());
                sendMessage("Orders waiting in queue: " + todayFoodOrders.size());
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sendMessage("Closing business. See you tomorrow!");
        });
        foodOnlineStoreThread.start();
    }

    public boolean acceptNewOrder(FoodOrder foodOrder) {
        if(!isOperating) {
            sendMessage("Sorry, business is closing and not accepting new orders. Place your order tomorrow.");
            return false;
        } else if(todayFoodOrders.size() >= MAX_ORDER_QUEUE_SIZE) {
            sendMessage("Sorry, the order queue is full, try again in a moment.");
            return false;
        }else {
            sendMessage("Accepting new food order: " + foodOrder);
            return todayFoodOrders.offer(foodOrder);
        }
    }

    public void stopOperating() {
        this.isOperating = false;
        sendMessage("Business is closing, it will not accept any more orders today. You can place orders tomorrow.");
    }

    private void sendMessage(String message) {
        System.out.println(message);
        messageService.acceptMessage(message);
    }

}
