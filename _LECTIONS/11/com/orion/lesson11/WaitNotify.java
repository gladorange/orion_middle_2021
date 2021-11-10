package com.orion.lesson11;

import java.util.ArrayList;
import java.util.List;

public class WaitNotify {


    static final Object notifies = new Object();
    public static void main(String[] args) throws InterruptedException {

        List<Integer> result = new ArrayList<>();


        Thread t = new Thread(() -> {
            System.out.println("Я выполняюсь");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            result.add(42);
            synchronized (notifies) {
                notifies.notify();
            }
            System.out.println("Я закончил выполняться");

            try {
                System.out.println("Другая важная задача");
                Thread.sleep(200000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }        });
        t.start();
        synchronized (notifies) {
            notifies.wait();
        }
        System.out.println(result);

    }
}
