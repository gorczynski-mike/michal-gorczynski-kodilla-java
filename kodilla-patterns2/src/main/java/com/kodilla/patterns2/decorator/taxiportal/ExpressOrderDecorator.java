package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class ExpressOrderDecorator extends AbstractTaxiOrderDecorator {

    public ExpressOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " express service";
    }
}
