package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThickCrustPizzaDecorator extends AbstractPizzaOrderDecorator {
    public ThickCrustPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " on thick crust";
    }
}
