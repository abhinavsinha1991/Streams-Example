package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parallelism {

    public static void main(String[] args) {
        performParallelism();
        reUse();
    }

    /**
     * Basic example of parallel streams
     */

    private static void performParallelism() {

        Double[] doubleArray = {1.8, 2.0, 3.2, 4.5, 5.6, 6.0, 7.0, 8.9};
        List<Double> listOfDouble =
                new ArrayList<>(Arrays.asList(doubleArray));

        listOfDouble
                .parallelStream()
                .filter(element -> element < 5)
                .mapToInt(Double::intValue)
                .forEach(System.out::println); // Results in a side effect

        Integer sumOfInteger = listOfDouble
                .parallelStream()
                .filter(element -> element < 5)
                .mapToInt(Double::intValue)
                .sum();                        // Returns a concrete value

        System.out.println("Sum of Integers less than 5 is : " + sumOfInteger);

    }

    private static void reUse() {

        Stream<String> stringValue = Stream.of("1", "2", "3");

        double result = stringValue
                .collect(Collectors.averagingDouble(Double::parseDouble));

        System.out.println(result);

        //Streams can be operated only once..it will through exception.

        double resultAgain = stringValue.count();
        System.out.println(resultAgain);
    }
}
