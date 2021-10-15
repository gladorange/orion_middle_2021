package com.orion.lesson5;

import java.io.IOException;

public class RuntimeExample {


    public static void main(String[] args) throws IOException, InterruptedException {
       // Runtime.getRuntime().exec("notepad.exe");

        System.out.println(System.getenv());
        System.out.println(System.getProperties());
    }
}
