package com.example.sanjeev.orderdemo.javaprograms.barclays;

import lombok.Builder;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class BarclaysTest {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);

        String line;

        while ((line = in.readLine()) != null) {

            String[] integers = line.split(";");

            Set<String> tempSet = new HashSet<>();
            Set<String> duplicates;
            String[] allInts = integers[1].split(",");
            duplicates = Arrays.stream(allInts)
                    .filter(item -> !tempSet.add(item))
                    .collect(Collectors.toSet());

            System.out.println(duplicates.stream().findAny().get());


            //final int number = Integer.valueOf(line);

            // int[] randInts = ThreadLocalRandom.current().ints().limit(5).toArray();


           /* List<Integer> list = Arrays.asList(2, 4, 5, 6);
            int sum = list.stream().collect(Collectors.summingInt(Integer::intValue));*/
            /*long sum = IntStream.rangeClosed(1, number)
                    .parallel()
                    .filter(val ue -> value % 5 != 0)
                    .filter(value -> value % 7 != 0)
                    .mapToLong(value -> value)
                    .sum();

            System.out.println(sum);*/


        }


    }


}
