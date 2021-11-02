package com.orion.lesson10;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedReading {


    public static void main(String[] args) throws IOException {
        readArray();
        readArrayBuffered();
    }


    private static void readBytePerByte() throws IOException {//20 секунд
        final long start = System.nanoTime();

        long readedBytes = 0L;
        try (FileInputStream fis = new FileInputStream("vim.txt")) {
            while (fis.read() != -1) {
                readedBytes++;
            }
        }

        System.out.println("Reading took:" + (System.nanoTime() - start) + " total symbols" + readedBytes);
    }


    private static void readArray() throws IOException {


        byte[] buffer = new byte[10_000];
        final long start = System.nanoTime();

        long readedBytes = 0L;
        try (FileInputStream fis = new FileInputStream("vim.txt")) {
            while (true) {
                final int read = fis.read(buffer);
                if (read == -1) break;
                readedBytes += read;
            }
        }

        System.out.println("Reading with array took:" + (System.nanoTime() - start) + " total symbols " + readedBytes);
    }


    private static void readArrayBuffered() throws IOException {

        final long start = System.nanoTime();

        long readedBytes = 0L;
        try (InputStream fis = new BufferedInputStream(new FileInputStream("vim.txt"))) {
            while (fis.read() != -1) {
                readedBytes++;
            }
        }

        System.out.println("Reading with buffer took:" + (System.nanoTime() - start) + " total symbols " + readedBytes);
    }
}
