package com.kodilla.stream.world;

import java.util.*;

public class Continent {

    private final Set<Country> countries = new HashSet<>();

    public Continent(Country... countries){
        this.countries.addAll(Arrays.asList(countries));
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }
}
