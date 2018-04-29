package com.kodilla.exception.test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        List<AbstractMap.SimpleEntry<Double, Double>> inputs = new ArrayList<>();
        inputs.add(new AbstractMap.SimpleEntry<>(1.6, 2.0));
        inputs.add(new AbstractMap.SimpleEntry<>(1.3, 1.5));
        inputs.add(new AbstractMap.SimpleEntry<>(0.2, 10.0));

        inputs.stream()
                .forEach(entry -> {
                    String s = null;
                    try {
                        s = secondChallenge.probablyIWillThrowException(entry.getKey(), entry.getValue());
                    } catch (Exception e) {
                        System.out.println("Exception occurred: " + e.getClass().getSimpleName());
                    } finally {
                        System.out.println(s);
                    }
                });
    }
}
