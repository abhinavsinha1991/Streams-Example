package com.example.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StreamsComparison {

    public static void main(String[] args) {
        List<Integer> listNumbers = Arrays.asList(1,2,3,45,66,0,4,68);
        System.out.println("Using sumIterator :" + sumIterator(listNumbers));
        System.out.println("Using sumStream :" + sumStream(listNumbers));
    }

    /**
     * First Solution : Using Iterator
     * @param list: List<Integer>
     * @return Integer
     */
    private static Integer sumIterator(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }

    /**
     * Second Solution : Using Stream
     * @param list: List<Integer>
     * @return Integer
     */
    private static Integer sumStream(List<Integer> list) {
        return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
    }

}

