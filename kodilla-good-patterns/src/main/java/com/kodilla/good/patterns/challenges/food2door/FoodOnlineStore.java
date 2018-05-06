package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Store main class, it contains the main Thread and main logic of the store.
 */
public class FoodOnlineStore {

    private static final int MAX_ORDER_QUEUE_SIZE = 10;

    private final Queue<FoodOrder> todayFoodOrders = new LinkedList<>();
    private final List<GenericFoodSupplier> foodSuppliers = new ArrayList<>();
    private UserInterface userInterface = new UserInterface(this);
    private MessageService messageService = userInterface;
    private final OrderProcessor foodOrderProcessor = new FoodOrderProcessor(userInterface, this);
    private boolean isOperating = true;
    private boolean isClosed = false;

    {
        addFoodSupplier(new EvenFoodShop());
        addFoodSupplier(new GlutenFreeShop());
        addFoodSupplier(new HealthyShop());
    }

    public FoodOnlineStore() {

        Thread foodOnlineStoreThread = new Thread(() -> {
            sendMessage("Food online store is now operating and waiting to process orders.");
            while(isOperating) {
                if (!todayFoodOrders.isEmpty()) {
                    processOneOrder();
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
                processOneOrder();
                sendMessage("Orders waiting in queue: " + todayFoodOrders.size());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sendMessage("Business is closed. See you tomorrow!");
            isClosed = true;
        });
        foodOnlineStoreThread.start();
    }

    public boolean acceptNewOrder(FoodOrder foodOrder) {
        if(isClosed) {
            sendMessage("Sorry, business is closed. Place your order tomorrow.");
            return false;
        } else if(!isOperating) {
            sendMessage("Sorry, business is closing and not accepting new orders. Place your order tomorrow.");
            return false;
        } else if(todayFoodOrders.size() >= MAX_ORDER_QUEUE_SIZE) {
            sendMessage("Sorry, the order queue is full, try again in a moment.");
            return false;
        }else {
            sendMessage(String.format("Accepting new food order: %n\t%s", foodOrder));
            return todayFoodOrders.offer(foodOrder);
        }
    }

    private void processOneOrder() {
        FoodOrder foodOrder = todayFoodOrders.poll();
        foodOrderProcessor.processOrder(foodOrder);
    }

    public void stopOperating() {
        if(isClosed == true) {
            sendMessage("Business is already closed.");
        } else if (!isOperating) {
            sendMessage("Business is already closing down.");
        } else {
            this.isOperating = false;
            sendMessage("Business is closing, it will not accept any more orders today. You can place orders tomorrow.");
        }
    }

    private void sendMessage(String message) {
        System.out.println("STORE INFO: " + message);
        messageService.acceptMessage("STORE INFO: " + message);
    }

    public boolean addFoodSupplier(GenericFoodSupplier foodSupplier) {
        return this.foodSuppliers.add(foodSupplier);
    }

    public boolean removeFoodSupplier(GenericFoodSupplier foodSupplier) {
        return this.foodSuppliers.remove(foodSupplier);
    }

    public List<GenericFoodSupplier> getFoodSuppliers() {
        return new ArrayList<>(foodSuppliers);
    }

    public GenericFoodSupplier getFoodSupplier(String foodSupplierName) {
        GenericFoodSupplier result = null;
        for(GenericFoodSupplier supplier: foodSuppliers) {
            if(supplier.getFoodSupplierName().equalsIgnoreCase(foodSupplierName)) {
                result = supplier;
            }
        }
        return result;
    }
}
