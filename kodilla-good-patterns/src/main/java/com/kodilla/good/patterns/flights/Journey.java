package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Journey {

    private final String fromCity;
    private final String toCity;
    private final List<Flight> flights = new ArrayList<>();

    public Journey(Flight flight, Flight... flightArray) {
        this.flights.add(flight);
        for(Flight f : flightArray) {
            this.flights.add(f);
        }
        this.fromCity = flights.get(0).getFromCity();
        this.toCity = flights.get(flights.size()-1).getToCity();
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\u0009Journey %s -> %s: %n\u0009", fromCity, toCity));
        String flightsChain = flights.stream()
                .map(Flight::toString)
                .collect(Collectors.joining(" -> "));
        sb.append(flightsChain);
        return sb.toString();
    }
}
