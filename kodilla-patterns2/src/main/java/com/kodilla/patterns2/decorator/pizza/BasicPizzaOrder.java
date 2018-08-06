package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(15);
    }

    @Override
    public String getDescription() {
        return "Standard pizza with tomato sauce and cheese";
    }
}
