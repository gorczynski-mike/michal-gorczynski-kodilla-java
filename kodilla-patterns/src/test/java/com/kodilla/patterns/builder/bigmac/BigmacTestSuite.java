package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BigmacTestSuite {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testBigmacCorrectNoExceptions() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder(Bigmac.Bun.ORDINARY, Bigmac.Sauce.BBQ)
                .ingredient(Bigmac.Ingredient.CHEESE)
                .ingredient(Bigmac.Ingredient.LETTUCE)
                .ingredient(Bigmac.Ingredient.PICKLE)
                .burgers(2)
                .build();
        //When & Then
        System.out.println(bigmac);
    }

    @Test
    public void testBigmacIncorrectNumberOfBurgers() {
        //Given
        boolean tooManyBurgersExceptionThrown = false;
        boolean tooFewBurgersExceptionThrown = false;

        //When
        try {
            Bigmac bigmacTooManyBurgers = new Bigmac.BigmacBuilder(Bigmac.Bun.ORDINARY, Bigmac.Sauce.BBQ)
                    .burgers(4)
                    .build();
        } catch (IllegalStateException e) {
            tooManyBurgersExceptionThrown = true;
        }
        try {
            Bigmac bigmacTooFewBurgers = new Bigmac.BigmacBuilder(Bigmac.Bun.ORDINARY, Bigmac.Sauce.BBQ)
                    .burgers(-1)
                    .build();
        } catch (IllegalStateException e) {
            tooFewBurgersExceptionThrown = true;
        }
        //Then
        Assert.assertTrue(tooManyBurgersExceptionThrown);
        Assert.assertTrue(tooFewBurgersExceptionThrown);
    }

}
