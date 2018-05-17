package com.kodilla.patterns.builder.pizza;

import org.junit.Assert;
import org.junit.Test;

public class PizzaTestSuite {

    @Test
    public void testPizzaNew() {
        //Given
//        Pizza pizza = new Pizza("Thin", "Spicy", "Mushrooms", "Onion", "Ham");
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Tomato")
                .ingredient("Onion")
                .ingredient("Ham")
                .bottom("Thick")
                .sauce("Tomato Sauce")
                .build();
        System.out.println(pizza);
        //When
        int howManyIngredients = pizza.getIngredients().size();
        //Then
        Assert.assertEquals(3, howManyIngredients);
    }

}