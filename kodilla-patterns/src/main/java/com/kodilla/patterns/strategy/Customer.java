package com.kodilla.patterns.strategy;

public class Customer {

    final private String name;
    protected BuyPredictor buyPredictor;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBuyingStrategy(BuyPredictor buyingStrategy) {
        this.buyPredictor = buyingStrategy;
    }

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }

}
