package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatefulLambda {

    /**
     * Example for stateful lambda exp
     */
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers =
                new ArrayList<>(Arrays.asList(intArray));
        statefulWithSerial(listOfIntegers);
        statefulWithParallel(listOfIntegers);
    }

    private static void statefulWithSerial(List<Integer> listOfIntegers) {

        List<Integer> serialStorage = new ArrayList<>();

        System.out.println("Serial stream:");
        listOfIntegers
                .stream()
                // Don't do this! It uses a stateful lambda expression.
                .map(element -> {
                    serialStorage.add(element);
                    return element;
                })
                .forEachOrdered(element -> System.out.print(element + " "));
        System.out.println("");

        serialStorage
                .stream()
                .forEachOrdered(element -> System.out.print(element + " "));
        System.out.println("");
    }
    private static void statefulWithParallel(List<Integer> listOfIntegers) {

        System.out.println("Parallel stream:");
        List<Integer> parallelStorage = Collections.synchronizedList(
                new ArrayList<>());
        listOfIntegers
                .parallelStream()
                // Don't do this! It uses a stateful lambda expression.
                .map(element -> {
                    parallelStorage.add(element);
                    return element;
                })
                .forEachOrdered(element -> System.out.print(element + " "));
        System.out.println("");

        parallelStorage
                .stream()
                .forEachOrdered(element -> System.out.print(element + " "));
        System.out.println("");
    }

}
