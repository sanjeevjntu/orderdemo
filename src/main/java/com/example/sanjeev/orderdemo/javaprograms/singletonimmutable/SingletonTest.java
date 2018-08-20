package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

public class SingletonTest {

    public static void main(String[] args) {
     //SingletonExample singletonExample = new SingletonExample();// Private Constructor

        System.out.println(SingletonExample.getInstance());
        System.out.println(SingletonExample.getInstance());
    }
}
