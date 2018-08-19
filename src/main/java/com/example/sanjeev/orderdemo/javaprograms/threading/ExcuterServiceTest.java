package com.example.sanjeev.orderdemo.javaprograms.threading;

import java.util.OptionalDouble;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class ExcuterServiceTest {

    public static void main(String[] args) {

        Runnable task=  () -> {
            OptionalDouble average = LongStream.rangeClosed(1, 1000).average();
            System.out.println(average.getAsDouble());
        };


        Future<?> future =  Executors.newFixedThreadPool(10).submit(task);
        if(!future.isDone()){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("Future get()>>>>>>>"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /**
         * 2. Callable with Submit, which gives future object
         */
        Callable<Double> callableTask1 =new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                OptionalDouble average = LongStream.rangeClosed(1, 1000).average();
                return average.getAsDouble();
            }
        };

        Future<Double> future1 = Executors.newFixedThreadPool(1).submit(callableTask1);

        try {
            System.out.println( future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
