package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class MytaxiNetworkOrderDecorator extends AbstractTaxiOrderDecorator {

    public MytaxiNetworkOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(30));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by Mytaxi Network";
    }
}
