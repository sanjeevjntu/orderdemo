package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

public class SingletonExample {

    private static final SingletonExample singletonExample = new SingletonExample();

    private SingletonExample(){ }
    public static SingletonExample getInstance(){
        return singletonExample;
    }

}
