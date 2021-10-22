package com.orion.lesson4.fabric.except;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CheckedException {


    public static void main(String[] args) throws IOException {
        writeSomethingToFile();


        int a = 0;
        System.out.println(42 / a);
    }

    private static void writeSomethingToFile() throws IOException {
        final FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream("some file.txt");
        fileOutputStream.write("string as bytes".getBytes());

    }
}
