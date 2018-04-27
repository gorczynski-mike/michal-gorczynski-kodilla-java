package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country(new BigDecimal(36_000_000));
        Country spain = new Country(new BigDecimal(46_000_000));
        Country portugal = new Country(new BigDecimal(10_000_000));
        Continent europe = new Continent(poland, spain, portugal);

        Country usa = new Country(new BigDecimal(325_000_000));
        Country canada = new Country(new BigDecimal(36_000_000));
        Country mexico = new Country(new BigDecimal(127_000_000));
        Continent northAmerica = new Continent(usa, canada, mexico);

        Country brazil = new Country(new BigDecimal(207_000_000));
        Country argentina = new Country(new BigDecimal(43_000_000));
        Country chile = new Country(new BigDecimal(17_000_000));
        Continent southAmerica = new Continent(brazil, argentina, chile);

        World world = new World(europe, northAmerica, southAmerica);

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal("847000000"), result);
    }

}
