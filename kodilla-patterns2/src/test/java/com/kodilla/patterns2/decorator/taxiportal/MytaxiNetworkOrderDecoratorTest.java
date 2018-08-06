package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MytaxiNetworkOrderDecoratorTest {

    @Test
    public void getCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MytaxiNetworkOrderDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(BigDecimal.valueOf(35.00d), calculatedCost);
    }

    @Test
    public void getDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MytaxiNetworkOrderDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Mytaxi Network", description);
    }
}