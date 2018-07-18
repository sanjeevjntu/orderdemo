package com.example.sanjeev.orderdemo.javaprograms.customstreams;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class ArraysStreamsTest {

    public static void main(String[] args) {

        int[] myArray = {1,2,3,4,5,6,7, 12, 34,32,12,44,3};
        int total = Arrays.stream(myArray).sum();

        OptionalDouble average = IntStream.of(myArray).average();

        double asDouble = average.getAsDouble();

        // .reduce(0,(left, right) -> left + right);

        log.info("total:{}", total);

        String[] strings = {"Kee", "Naisha", "Sanjeev"};

        log.info("strings:{}",strings);
       /* String sentence = Arrays.stream(strings)
                .reduce("", (s, s2) -> s.concat(s2));
*/
       // log.info("sentence:{}", sentence);

     /*   String[] stringArray = Arrays.stream(strings)
                .sorted((o1, o2) -> o1.length()-o2.length())
                .toArray(String[]::new);*/


        String[] strings1 = Stream.of(strings)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);

        for (String string: strings1) {
            System.out.println(string);
        }

    }
}
