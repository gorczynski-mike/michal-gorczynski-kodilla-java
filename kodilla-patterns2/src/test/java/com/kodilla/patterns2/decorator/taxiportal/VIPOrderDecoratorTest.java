package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VIPOrderDecoratorTest {

    @Test
    public void getCostTaxiNetworkWithChildSeatExpressVIP() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        theOrder = new ExpressOrderDecorator(theOrder);
        theOrder = new VIPOrderDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(BigDecimal.valueOf(57.00d), calculatedCost);
    }

    @Test
    public void getDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        theOrder = new ExpressOrderDecorator(theOrder);
        theOrder = new VIPOrderDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network + child seat express service VIP service", description);
    }
}