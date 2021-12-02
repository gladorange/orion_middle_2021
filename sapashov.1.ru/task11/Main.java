package task11;

import task10.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> content = new CopyOnWriteArrayList<>();
        List<String> links = new LinkedList<>();
        String link1 = "https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html";
        String link2 = "https://docs.oracle.com/javase/tutorial/index.html";
        String link3 = "https://docs.oracle.com/javase/tutorial/getStarted/index.html";
        String link4 = "https://docs.oracle.com/javase/tutorial/java/index.html";
        String link5 = "https://docs.oracle.com/javase/tutorial/essential/index.html";
        String link6 = "https://docs.oracle.com/javase/tutorial/collections/index.html";
        String link7 = "https://docs.oracle.com/javase/tutorial/datetime/index.html";
        String link8 = "https://docs.oracle.com/javase/tutorial/deployment/index.html";
        String link9 = "https://docs.oracle.com/javase/tutorial/extra/certification/index.html";
        String link10 = "https://docs.oracle.com/javase/tutorial/uiswing/index.html";

        links.add(link1);
        links.add(link2);
        links.add(link3);
        links.add(link4);
        links.add(link5);
        links.add(link6);
        links.add(link7);
        links.add(link8);
        links.add(link9);
        links.add(link10);

        String parallelPath = "D:\\projects\\orion_middle_2021\\sapashov.1.ru\\task11\\parallel.txt";
        FileManager fileManager = new FileManager();

        for (String link : links) {
            System.out.printf("\n=========  Begin %s  ========", link);
            try {
                byte[] bytes = new URL(link).openStream().readAllBytes();
                String str = new String(bytes);
                fileManager.addText(parallelPath, str);
                content.add(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("\n=========  End %s  ========", link);
            System.out.println();
        }


    }
}
