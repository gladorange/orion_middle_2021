package com.orion.lesson11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        final ExecutorService executorService = Executors.newFixedThreadPool(15);

        final long before = System.currentTimeMillis();


        final Future<Integer> task1Result = executorService.submit(() -> {
            final long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 4000) {
            }
            return 42;
        });

        final Future<Integer> task2Result = executorService.submit(() -> {
            final long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 4000) {
            }
            return 84;
        });


        System.out.println(task1Result.get() + task2Result.get());

        System.out.println(System.currentTimeMillis() - before);
        executorService.shutdown();
    }
}
