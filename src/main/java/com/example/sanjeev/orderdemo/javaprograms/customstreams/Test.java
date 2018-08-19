package com.example.sanjeev.orderdemo.javaprograms.customstreams;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {

        int[] intArray = {1,2,3,4,5,11,23,100,123, 90};
        System.out.println(findNumber(intArray, 33));
        System.out.println(oddNumbers(1, 100));
    }

    static String findNumber(int[] arr, int k) {
        boolean b = Arrays.stream(arr).anyMatch(value -> value == k);
        return b ? "YES" : "NO";

    }

    static int[] oddNumbers(int l, int r) {
        return IntStream.range(l, r)
                .filter(num -> num % 2 == 1)
                .toArray();
    }
}