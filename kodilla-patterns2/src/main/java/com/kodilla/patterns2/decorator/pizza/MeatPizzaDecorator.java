package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MeatPizzaDecorator extends AbstractPizzaOrderDecorator {
    public MeatPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(4));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + meat";
    }
}
