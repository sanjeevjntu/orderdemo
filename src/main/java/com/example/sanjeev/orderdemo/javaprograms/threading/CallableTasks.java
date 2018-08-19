package com.example.sanjeev.orderdemo.javaprograms.threading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CallableTasks {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 3. Callabletasks with Submit, which gives future object
         */
        Callable<Double> callableTask1 = () -> IntStream.rangeClosed(1, 10_1000_1000).average().getAsDouble();
        Callable<Double> callableTask2 = () -> IntStream.rangeClosed(10_1000_1000, 20_1000_1000).average().getAsDouble();
        Callable<Double> callableTask3 = () -> IntStream.rangeClosed(20_1000_1000, 21_1000_1000).average().getAsDouble();
        List<Callable<Double>> callableTasksList = Arrays
                .asList(callableTask1, callableTask2, callableTask3);

        List<Future<Double>> futures = Executors.newFixedThreadPool(4).invokeAll(callableTasksList);
        /*List<Double> collect = futures.stream().map(doubleFuture -> {
            try {
                return doubleFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).collect(Collectors.toList());*/

    }
}
