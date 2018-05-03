package com.kodilla.good.patterns.flights;

import java.util.*;
import java.util.stream.Collectors;

public class FlightFinder {

    private final Flights flights;

    public FlightFinder(Flights flights) {
        this.flights = flights;
    }

    public Set<Flight> findAllFlightsFromCity(String city) {
        Set<Flight> result = flights.getFlights().stream()
                .filter(flight -> flight.getFromCity().equalsIgnoreCase(city))
                .collect(Collectors.toSet());
        return result;
    }

    public Set<Flight> findAllFlightsToCity(String city) {
        Set<Flight> result = flights.getFlights().stream()
                .filter(flight -> flight.getToCity().equalsIgnoreCase(city))
                .collect(Collectors.toSet());
        return result;
    }

    public Set<Flight> findFlightsFromCityToCityDirect(String startCity, String endCity) {
        Set<Flight> result = flights.getFlights().stream()
                .filter(flight -> flight.getFromCity().equalsIgnoreCase(startCity) &&
                        flight.getToCity().equalsIgnoreCase(endCity))
                .collect(Collectors.toSet());
        return result;
    }

    public List<AbstractMap.SimpleEntry<Flight, Flight>> findFlightsFromCityToCityOneStop(String startCity, String endCity) {
        List<AbstractMap.SimpleEntry<Flight, Flight>> result = new ArrayList<>();
        Set<Flight> flightsFromStartCity = findAllFlightsFromCity(startCity);
        Set<Flight> flightsToEndCity = findAllFlightsToCity(endCity);

        for(Flight flight1 : flightsFromStartCity) {
            for(Flight flight2 : flightsToEndCity) {
                if(flight1.equals(flight2)) {
                    continue;
                }
                if(flight1.getToCity().equalsIgnoreCase(flight2.getFromCity())) {
                    result.add(new AbstractMap.SimpleEntry<>(flight1, flight2));
                }
            }
        }

        return result;
    }

}
