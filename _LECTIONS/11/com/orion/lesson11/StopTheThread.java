package com.orion.lesson11;

public class StopTheThread {
}

class SomeThread extends Thread {


    public static void main(String[] args) throws InterruptedException {
        final SomeThread someThread = new SomeThread();
        someThread.start();
        Thread.sleep(2000);
        someThread.stop();

    }
    @Override
    public void run() {


        while (true) {
            try {
                Thread.sleep(500);
                System.out.println("Я ничего не делаю");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

