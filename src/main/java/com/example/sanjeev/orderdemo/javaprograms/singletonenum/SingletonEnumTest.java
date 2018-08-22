package com.example.sanjeev.orderdemo.javaprograms.singletonenum;

public class SingletonEnumTest {

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());

    }
}
