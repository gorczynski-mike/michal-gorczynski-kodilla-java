package com.kodilla.good.patterns.flights;

import java.util.Objects;

/**
 * A single flight from one city to another
 */
public class Flight {

    private static int totalFlights = 100;

    private final String fromCity;
    private final String toCity;
    private final int flightNumber;

    public Flight(final String fromCity, final String toCity) {
        if(fromCity.equalsIgnoreCase(toCity)) {
            throw new IllegalArgumentException("FROM city: " + fromCity + " cannot be the same as TO city: " + toCity);
        }
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.flightNumber = totalFlights++;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    @Override
    public String toString() {
        return "Flight" + flightNumber + "{" + fromCity + " to " + toCity + "}";
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
