package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaDecoratorTestSuite {

    @Test
    public void testBasicPizzaOrderCostAndDescription() {
        //Given & When
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //Then
        assertEquals(BigDecimal.valueOf(15), pizzaOrder.getCost());
        assertEquals("Standard pizza with tomato sauce and cheese", pizzaOrder.getDescription());
    }

    @Test
    public void testBasicPizzaThickCrustDoubleSauceOrderCostAndDescription() {
        //Given & When
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThickCrustPizzaDecorator(pizzaOrder);
        pizzaOrder = new DoubleSaucePizzaDecorator(pizzaOrder);
        //Then
        assertEquals(BigDecimal.valueOf(20), pizzaOrder.getCost());
        assertEquals("Standard pizza with tomato sauce and cheese on thick crust double sauce", pizzaOrder.getDescription());
    }

    @Test
    public void testPizzaThickCrsutDoubleSauceFourCheeseMeatOrderCostAndDescription() {
        //Given & When
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThickCrustPizzaDecorator(pizzaOrder);
        pizzaOrder = new DoubleSaucePizzaDecorator(pizzaOrder);
        pizzaOrder = new FourCheesePizzaDecorator(pizzaOrder);
        pizzaOrder = new MeatPizzaDecorator(pizzaOrder);
        //Then
        assertEquals(BigDecimal.valueOf(29), pizzaOrder.getCost());
        assertEquals("Standard pizza with tomato sauce and cheese on thick crust double sauce " +
                "+ four types of cheese + meat", pizzaOrder.getDescription());
    }

}
