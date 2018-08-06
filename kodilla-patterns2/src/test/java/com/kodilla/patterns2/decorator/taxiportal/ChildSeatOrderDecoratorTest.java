package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChildSeatOrderDecoratorTest {

    @Test
    public void getCostMyTaxiWithChildSeat() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MytaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(BigDecimal.valueOf(37.00d), calculatedCost);
    }

    @Test
    public void getDescriptionMyTaxiWithChildSeat() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MytaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Mytaxi Network + child seat", description);
    }

    @Test
    public void getCostUberWithTwoChildSeats() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(BigDecimal.valueOf(29.00d), calculatedCost);
    }

    @Test
    public void getDescriptionUberWithTwoChildSeat() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        theOrder = new ChildSeatOrderDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }
}