package com.kodilla.good.patterns.challenges.food2door;

public enum FoodOrderReturnCode {
    NULL(0),
    ALL_OK_ORDER_ACCEPTED(1),
    NO_SUCH_SUPPLIER(2),
    NO_SUCH_PRODUCT(101),
    NOT_ENOUGH_IN_STOCK(102),
    NOT_EVEN_QUANTITY(103),
    NOT_LUXURY_ENOUGH(201),
    NOT_HEALTHY_ENOUGH(202),
    NOT_GLUTEN_FREE(203),
    WE_DO_NOT_SHIP_TO_ANDREW(301);

    private final int returnCode;

    FoodOrderReturnCode(int rejectionCode) {
        this.returnCode = rejectionCode;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    @Override
    public String toString() {
        return "FoodOrderReturnCode{" +
                "returnCode=" + returnCode + " : " +
                this.name() +
                '}';
    }
}
