package com.orion.lesson11;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StopWithVariable {


    public static void main(String[] args) throws InterruptedException {
        final ThreadWriter thread = new ThreadWriter();
        thread.start();
        thread.join(1000);
        if (thread.isAlive()) {
            System.out.println("Поток работает долго - останавливаем");
            thread.interrupt();
        }


        System.out.println("Конец main");


    }

    public static class ThreadWriter extends Thread {

        @Override
        public void run() {
            List<String> toWrite = new ArrayList<>();
            toWrite.addAll(Arrays.asList("A", "b", "c"));


            try (FileWriter fileWriter = new FileWriter("test.txt")) {
                for (String s : toWrite) {

                    if (Thread.interrupted()) {
                        System.out.println("Меня остановили");
                        break;
                    }

                    fileWriter.write(s);
                    System.out.println(s);

                    long start = System.currentTimeMillis();

                    while (System.currentTimeMillis() - start < 1000) {

                    }
                    //Thread.sleep(1000);
                }
            } catch (IOException  e) {
                e.printStackTrace();
            }
            System.out.println("Конец долгого потока");
        }
    }
}
