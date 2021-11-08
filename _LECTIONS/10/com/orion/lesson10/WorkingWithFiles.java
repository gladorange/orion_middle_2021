package com.orion.lesson10;

import java.io.File;

public class WorkingWithFiles {


    public static void main(String[] args) {
        File directory = new File("test/directory/3rd level");


        if (!directory.exists()) {
            System.out.println("Создаем папки");
            directory.mkdirs();
        }


        if (directory.isDirectory()) {
            System.out.println("Это папка");
        }

        if (directory.isFile()) {
            System.out.println("Это файл");
        }
    }
}
