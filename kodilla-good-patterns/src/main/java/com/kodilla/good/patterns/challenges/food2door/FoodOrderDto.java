package com.kodilla.good.patterns.challenges.food2door;

import java.util.*;

/**
 * Unlike FoodOrder it doesn't have supplier field and it provides list of valid return codes to supplier. Use it to
 * communicate with FoodSuppliers.
 */
public class FoodOrderDto {

    private final String customer;
    private final String productName;
    private final int quantity;
    private final Map<Integer, FoodOrderReturnCode> returnCodes = new HashMap<>();

    public FoodOrderDto(String customer, String productName, int quantity) {
        this.customer = customer;
        this.productName = productName;
        this.quantity = quantity;
        for(FoodOrderReturnCode returnCode : FoodOrderReturnCode.values()) {
            returnCodes.put(returnCode.getReturnCode(), returnCode);
        }
    }

    public FoodOrderDto(FoodOrder foodOrder) {
        this(foodOrder.getCustomer(), foodOrder.getProductName(), foodOrder.getQuantity());
    }

    public String getCustomer() {
        return customer;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Map<Integer, FoodOrderReturnCode> getReturnCodes() {
        return returnCodes;
    }
}
