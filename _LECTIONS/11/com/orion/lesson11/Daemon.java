package com.orion.lesson11;

public class Daemon {


    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            while (true) {
            }
        });
        thread.setDaemon(true);
        thread.start();

        System.out.println("Конец");
    }
}
