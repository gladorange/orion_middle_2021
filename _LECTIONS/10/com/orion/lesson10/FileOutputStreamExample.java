package com.orion.lesson10;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamExample {


    public static void main(String[] args) throws IOException {

        String hello = "Hello, World!";


        try (OutputStream fos = new BufferedOutputStream(new FileOutputStream("my-hello.txt"))) {
            for (byte aByte : hello.getBytes(StandardCharsets.UTF_8)) {
                fos.write(aByte);
            }
        }

    }
}
