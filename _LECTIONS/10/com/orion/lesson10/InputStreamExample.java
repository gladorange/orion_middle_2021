package com.orion.lesson10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputStreamExample {


    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("numbers.txt");

        int firstByte = fis.read();
        while (firstByte != -1) {
            System.out.println(firstByte);
            firstByte = fis.read();
        }

        System.out.println("поток закрылся");
        fis.close();



        FileReader fr = new FileReader("numbers.txt");

        int firstByteFr = (char)fr.read();
        while (firstByteFr != -1) {
            System.out.println(firstByteFr);
            firstByteFr = fr.read();
        }

        System.out.println("Чтец закрылся");
        fr.close();

    }
}
