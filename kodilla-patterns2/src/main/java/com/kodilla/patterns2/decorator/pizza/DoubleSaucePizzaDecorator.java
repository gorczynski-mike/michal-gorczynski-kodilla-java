package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class DoubleSaucePizzaDecorator extends AbstractPizzaOrderDecorator {
    public DoubleSaucePizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " double sauce";
    }
}
