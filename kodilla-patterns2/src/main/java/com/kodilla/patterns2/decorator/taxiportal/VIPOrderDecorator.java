package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class VIPOrderDecorator extends AbstractTaxiOrderDecorator {
    public VIPOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " VIP service";
    }
}
