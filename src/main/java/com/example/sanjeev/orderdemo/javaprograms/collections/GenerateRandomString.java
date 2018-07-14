package com.example.sanjeev.orderdemo.javaprograms.collections;

import org.apache.commons.lang.RandomStringUtils;

public class GenerateRandomString {

    public static void main(String[] args){

        String s = RandomStringUtils.randomAlphanumeric(20);

        System.out.println(s);
    }
}
