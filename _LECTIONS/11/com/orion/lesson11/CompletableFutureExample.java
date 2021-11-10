package com.orion.lesson11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {


    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(4);

        final CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> {
            final long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 4000) {
            }
            return 42;
        }, executorService);

        final CompletableFuture<Integer> second = CompletableFuture.supplyAsync(() -> {
            final long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 4000) {
            }
            return 42;
        }, executorService);

        first.thenAccept(value -> {
            System.out.println("Первое готово " + value);
        });
        second.thenAccept(value -> {
            System.out.println("Второе готово " + value);
        });

        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(first, second);

        System.out.println("Конец");
    }
}
