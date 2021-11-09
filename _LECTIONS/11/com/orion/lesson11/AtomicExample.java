package com.orion.lesson11;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    static volatile AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {


        Thread t = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                counter.incrementAndGet();
            }
        });
        t.start();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                counter.incrementAndGet();
            }
        });
        t1.start();
        t.join();
        t1.join();


        System.out.println(counter);
    }
}
