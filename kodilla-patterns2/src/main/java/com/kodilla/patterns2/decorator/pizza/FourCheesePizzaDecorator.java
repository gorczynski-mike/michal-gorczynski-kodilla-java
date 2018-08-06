package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class FourCheesePizzaDecorator extends AbstractPizzaOrderDecorator {
    public FourCheesePizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + four types of cheese";
    }
}
