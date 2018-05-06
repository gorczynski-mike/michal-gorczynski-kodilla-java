package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unlike FoodOrder it doesn't have supplier field and it provides list of return codes to supplier. Use it to
 * communicate with FoodSuppliers.
 */
public class FoodOrderDto {

    private final String customer;
    private final String productName;
    private final int quantity;
    private final List<FoodOrderReturnCode> returnCodes;

    public FoodOrderDto(String customer, String productName, int quantity) {
        this.customer = customer;
        this.productName = productName;
        this.quantity = quantity;
        this.returnCodes = new ArrayList<FoodOrderReturnCode>(Arrays.asList(FoodOrderReturnCode.values()));
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

}
