package com.example.sanjeev.orderdemo.walmart;

import java.util.Arrays;

public class Walmart {

    public static void main(String[] args) {
        String s1 = "Sanjeev";
        String s2 = "Snajeev";

        boolean anagram = isAnagram(s1, s2);
        System.out.println(anagram);

    }

    private static boolean isAnagram(String s1, String s2) {

        System.out.println(s1.chars().sorted().toArray());

       return  Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());

    }
}
