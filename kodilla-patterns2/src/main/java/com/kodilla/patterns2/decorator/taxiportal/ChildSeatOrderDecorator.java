package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class ChildSeatOrderDecorator extends AbstractTaxiOrderDecorator {

    public ChildSeatOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + child seat";
    }
}
