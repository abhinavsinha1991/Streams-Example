package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interference {

    /**
     * Example of interference ,
     * This will through ConcurrentModificationException
     */
    public static void main(String[] args) {

        try {
            List<String> listOfStrings =
                    new ArrayList<>(Arrays.asList("one", "two", "three"));

            listOfStrings
                    .parallelStream()
                    .map(singleElement -> {
                        listOfStrings.add("four");
                        return listOfStrings;
                    })
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }
    }
}
