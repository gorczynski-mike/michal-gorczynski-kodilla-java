package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class World {

    private final Set<Continent> continents = new HashSet<>();

    public World(Continent... continents){
        this.continents.addAll(Arrays.asList(continents));
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return peopleQuantity;
    }

}
