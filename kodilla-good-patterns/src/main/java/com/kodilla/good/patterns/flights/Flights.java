package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;

public class Flights {

    private final Set<Flight> flights = new HashSet<>();

    public static Flights getSampleFlights(){
        return new Flights(
                new Flight("Warsaw", "Berlin"),
                new Flight("Warsaw", "Poznan"),
                new Flight("Warsaw", "Krakow"),
                new Flight("Warsaw", "Gdansk"),
                new Flight("Krakow", "Berlin"),
                new Flight("Krakow", "Poznan"),
                new Flight("Poznan", "Warsaw"),
                new Flight("Berlin", "Warsaw"),
                new Flight("Berlin", "Gdansk"),
                new Flight("Gdansk", "Berlin")
        );
    }

    public Flights(Flight... flights) {
        for(Flight flight : flights) {
            this.addFlight(flight);
        }
        System.out.println("Created new flights collection: ");
        this.flights.stream().forEach(System.out::println);
    }

    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }

    public Set<Flight> getFlights() {
        return new HashSet<>(flights);
    }

}
