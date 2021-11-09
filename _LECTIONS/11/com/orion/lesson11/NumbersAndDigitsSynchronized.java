package com.orion.lesson11;

import java.util.List;

public class NumbersAndDigitsSynchronized {


    final static Object lock = new Object();


    public static void main(String[] args) {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> letters = List.of("A", "B", "C", "D", "E", "F", "G", "H", "J");


        final ThreadPrinter е1 = new ThreadPrinter(numbers);
        е1.start();
        final ThreadPrinter е2 = new ThreadPrinter(letters);
        е2.start();


    }




    public static class ThreadPrinter extends Thread {


        private final List<String> toPrint;

        public ThreadPrinter(List<String> toPrint) {
            this.toPrint = toPrint;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (String s : toPrint) {
                    System.out.println(s);
                }
            }
        }
    }
}
