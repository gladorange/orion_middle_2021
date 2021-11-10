package com.orion.lesson11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentExample {


    public static void main(String[] args) throws InterruptedException {
        Collection<Integer> numbers = new LinkedBlockingQueue<>();


        Thread t = new Thread(() -> {
            for (int i = 0; i < 200000; i++) {
                numbers.add(i);
            }
        });
        t.start();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200000; i++) {
                numbers.add(i);
            }
        });
        t1.start();
        t.join();
        t1.join();


        System.out.println(numbers.size());

    }
}
