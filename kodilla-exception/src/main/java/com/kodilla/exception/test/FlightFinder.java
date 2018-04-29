package com.kodilla.exception.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightFinder {

    private Map<String, Boolean> arrivalAirports = generateArrivalAirportsMap();
    private Map<String, Boolean> departureAirports = generateDepartureAirportsMap();

    public static void main(String[] args){
        FlightFinder flightFinder = new FlightFinder();
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Warsaw", "London"));
        flights.add(new Flight("Berlin", "Madrid"));
        flights.add(new Flight("Lisbon", "Warsaw"));
        flights.add(new Flight("Warsaw", "Moscow"));
        flights.add(new Flight("Cairo", "Moscow"));

        for(Flight flight : flights){
            try {
                System.out.println("Searching for flight: " + flight);
                boolean result = flightFinder.findFlight(flight);
                System.out.println("Is the flight possible? " + result);
            } catch (RouteNotFoundException e) {
                System.out.println("Exception encountered: " + e.getClass().getSimpleName() + " : " + e.getMessage());
            } finally {
                System.out.println("Search for flight: " + flight + " was made on " + LocalDateTime.now());
            }
            System.out.println();
        }
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        Boolean arrivalOK = arrivalAirports.get(flight.getArrivalAirport());
        Boolean departureOK = departureAirports.get(flight.getDepartureAirport());

        if(departureOK == null && arrivalOK == null) {
            throw new RouteNotFoundException("No such airports in the database: " + flight.getDepartureAirport() +
                                                ", " + flight.getArrivalAirport());
        }
        if(departureOK == null) {
            throw new RouteNotFoundException("No such airport in the database: " + flight.getDepartureAirport());
        }
        if(arrivalOK == null) {
            throw new RouteNotFoundException("No such airport in the database: " + flight.getArrivalAirport());
        }

        return (arrivalOK && departureOK);
    }

    private Map<String,Boolean> generateArrivalAirportsMap() {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw", true);
        airports.put("Berlin", true);
        airports.put("London", true);
        airports.put("Madrid", true);
        airports.put("Prague", false);
        airports.put("Lisbon", false);
        airports.put("Rome", false);
        return airports;
    }

    private Map<String,Boolean> generateDepartureAirportsMap() {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw", true);
        airports.put("Berlin", false);
        airports.put("London", true);
        airports.put("Madrid", false);
        airports.put("Prague", false);
        airports.put("Lisbon", true);
        airports.put("Rome", false);
        return airports;
    }

}
