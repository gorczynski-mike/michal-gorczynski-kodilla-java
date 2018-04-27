package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){
        System.out.println("Numbers given in array: ");
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);

        OptionalDouble average = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();

        double result;
        if(average.isPresent()) {
            result = average.getAsDouble();
        } else {
            result = Double.NaN;
        }
        System.out.println("The average is: " + result);
        System.out.println();
        return result;
    }

}
