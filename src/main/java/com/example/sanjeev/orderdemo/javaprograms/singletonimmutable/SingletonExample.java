package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

/**
 * 1. Eager initialization:
 * In eager initialization, the instance of
 * Singleton Class is created at the time of class loading,
 * this is the easiest method to create a Singleton class.
 *
 * This approach has one drawback. Here instance is created even though client application might not be using it.
 * This might be a considerable issue if your Singleton class in creating a database connection or creating a socket.
 * This may cause the memory leak problem. The solution is to create the new instance of the class, when needed. This can be achieved by Lazy Initialization method.
 *
 */
public class SingletonExample {

    private static final SingletonExample singletonExample = new SingletonExample();

    private SingletonExample(){ }
    public static SingletonExample getInstance(){
        return singletonExample;
    }

}
