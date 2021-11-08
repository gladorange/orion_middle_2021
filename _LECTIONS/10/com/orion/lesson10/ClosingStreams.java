package com.orion.lesson10;

import java.io.FileInputStream;
import java.io.IOException;

public class ClosingStreams {


    public static void main(String[] args) throws Exception {
        workWithFInally();
        workWithTryWithResources();


    }

    private static void workWithFInally() throws IOException {
        FileInputStream fis = new FileInputStream("numbers.txt");

        try {
            int firstByte = fis.read();
            while (firstByte != -1) {
                System.out.println(firstByte);
                firstByte = fis.read();
            }
        } finally {
            System.out.println("поток закрылся");
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void workWithTryWithResources() throws IOException {

        try ( FileInputStream fis = new FileInputStream("numbers.txt")) {
            int firstByte = fis.read();
            while (firstByte != -1) {
                System.out.println(firstByte);
                firstByte = fis.read();
            }
        }
    }
}
