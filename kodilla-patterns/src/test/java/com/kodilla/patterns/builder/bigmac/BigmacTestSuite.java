package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BigmacTestSuite {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testBigmacCorrect() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bigmac.Bun.ORDINARY)
                .sauce(Bigmac.Sauce.BBQ)
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
        boolean tooManyExceptionThrown = false;
        boolean tooLittleExceptionThrown = false;

        //When
        try {
            Bigmac bigmacTooMany = new Bigmac.BigmacBuilder()
                    .bun(Bigmac.Bun.ORDINARY)
                    .sauce(Bigmac.Sauce.BBQ)
                    .burgers(4)
                    .build();
        } catch (IllegalStateException e) {
            tooManyExceptionThrown = true;
        }
        try {
            Bigmac bigmacTooLittle = new Bigmac.BigmacBuilder()
                    .bun(Bigmac.Bun.ORDINARY)
                    .sauce(Bigmac.Sauce.BBQ)
                    .burgers(-1)
                    .build();
        } catch (IllegalStateException e) {
            tooLittleExceptionThrown = true;
        }
        //Then
        Assert.assertTrue(tooManyExceptionThrown);
        Assert.assertTrue(tooLittleExceptionThrown);
    }

    @Test
    public void testBigmacIncorrectBunOrSauceMissing() {
        //Given
        boolean sauceMissingExceptionThrown1 = false;
        boolean bunMissingExceptionThrown2 = false;

        //When
        try {
            Bigmac bigmac1 = new Bigmac.BigmacBuilder()
                    .bun(Bigmac.Bun.SESAME)
                    .build();
        } catch (IllegalStateException e) {
            sauceMissingExceptionThrown1 = true;
        }

        try {
            Bigmac bigmac2 = new Bigmac.BigmacBuilder()
                    .sauce(Bigmac.Sauce.BBQ)
                    .build();
        } catch (IllegalStateException e) {
            bunMissingExceptionThrown2 = true;
        }

        //Then
        Assert.assertTrue(sauceMissingExceptionThrown1);
        Assert.assertTrue(bunMissingExceptionThrown2);
    }

}
