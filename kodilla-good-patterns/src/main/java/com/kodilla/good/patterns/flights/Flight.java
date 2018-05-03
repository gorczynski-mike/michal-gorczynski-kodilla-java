package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class Flight {

    private final String fromCity;
    private final String toCity;

    public Flight(final String fromCity, final String toCity) {
        if(fromCity.equalsIgnoreCase(toCity)) {
            throw new IllegalArgumentException("FROM city: " + fromCity + " cannot be the same as TO city: " + toCity);
        }
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(fromCity, flight.fromCity) &&
                Objects.equals(toCity, flight.toCity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fromCity, toCity);
    }
}
