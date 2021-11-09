package com.orion.lesson11;

import java.lang.Thread.UncaughtExceptionHandler;

public class Exceptions {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Begin");


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if (true) {
                    throw new IllegalArgumentException("Just a test");
                }
                System.out.println("End");
            }
        });
        t.setName("Поток, который с исключением");

        t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("В потоке " + t.getName() + " случилось исключение " + e.getMessage());
            }
        });

        t.start();
        t.join();


        System.out.println("Конец main");

    }
}
