package com.kodilla.good.patterns.challenges.food2door;

public enum FoodOrderReturnCode {
    NULL(0),
    ALL_OK_ORDER_ACCEPTED(1),
    NO_SUCH_PRODUCT(101),
    NOT_ENOUGH_IN_STOCK(102),
    NOT_LUXURY_ENOUGH(201),
    NOT_HEALTHY_ENOUGH(202),
    NOT_GLUTEN_FREE(203);

    private final int rejectionCode;

    FoodOrderReturnCode(int rejectionCode) {
        this.rejectionCode = rejectionCode;
    }

    public int getRejectionCode() {
        return this.rejectionCode;
    }

    @Override
    public String toString() {
        return "FoodOrderReturnCode{" +
                "rejectionCode=" + rejectionCode +
                '}';
    }
}
