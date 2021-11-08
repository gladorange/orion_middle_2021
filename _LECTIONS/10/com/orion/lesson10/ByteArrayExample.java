package com.orion.lesson10;

import java.io.ByteArrayInputStream;

public class ByteArrayExample {


    public static void main(String[] args) {
        String hello = "Hello, World!";


        final byte[] bytes = hello.getBytes();


        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

        int read;
        while ((read = bais.read() )!= -1) {
            System.out.println((char) read);
        }

    }
}
