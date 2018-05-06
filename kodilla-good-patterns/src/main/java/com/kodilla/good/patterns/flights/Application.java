package com.kodilla.good.patterns.flights;

public class Application {

    public static void main(String[] args) {

        Flights flights = Flights.getSampleFlights();
        FlightFinder flightFinder = new FlightFinder(flights);
        System.out.println();
        System.out.println("Flights from Warsaw: ");
        flightFinder.findAllFlightsFromCity("Warsaw").stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Flights to Warsaw: ");
        flightFinder.findAllFlightsToCity("Warsaw").stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Flights from Krakow to Warsaw with one stop: ");
        flightFinder.findFlightsFromCityToCityOneStop("Krakow", "Warsaw").stream().forEach(System.out::println);
        System.out.println();

    }

}
