package com.example.sanjeev.orderdemo.javaprograms.singletonmultithreaded;

/**
 * check with and wihtout synchronized getIntance()
 */
public class TestSingletonIn_MultiThreaded {

    public static void main(String[] args) {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                LazySynchronisedSingleTon instance1 = LazySynchronisedSingleTon.getInstance();
                System.out.println("Instance 1 hash:" + instance1.hashCode());
            }
        });

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                LazySynchronisedSingleTon instance2 = LazySynchronisedSingleTon.getInstance();
                System.out.println("Instance 1 hash:" + instance2.hashCode());
            }
        });

        t1.start();
        t2.start();
    }
}
