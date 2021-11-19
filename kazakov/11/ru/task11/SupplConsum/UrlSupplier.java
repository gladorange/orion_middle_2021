package ru.task11.SupplConsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class UrlSupplier implements Runnable {
    static int count = 0;
    final int id = count++;
    final Map.Entry<URL, String> entry;
    final UrlConsumer consumer;
    final UrlsNanoTiming urlsNanoTiming;

    public UrlSupplier(Map.Entry<URL, String> entry, UrlConsumer consumer, UrlsNanoTiming urlsNanoTiming) {
        this.entry = entry;
        this.consumer = consumer;
        this.urlsNanoTiming = urlsNanoTiming;
    }

    @Override
    public void run() {
        try {
            //  замеряем время:
            long startTime = System.nanoTime();
            //  читаем наш Url:
            String inputLine;
            final StringBuilder urlContent = new StringBuilder();
            final BufferedReader in = new BufferedReader(new InputStreamReader(entry.getKey().openStream()));
            while ((inputLine = in.readLine()) != null && !Thread.interrupted()) {
//                System.out.println(inputLine);
                urlContent.append(inputLine);
            }
            in.close();
            //  записываем содержимое url:
            entry.setValue(urlContent.toString());
            //  замеряем время:
            long endTime = System.nanoTime();
            //  уведомляем consumer'a что готов новый Url:
            synchronized (consumer) {
                consumer.notify();
            }
            synchronized (urlsNanoTiming) {
                if (startTime < urlsNanoTiming.startTime) {
                    urlsNanoTiming.startTime = startTime;
                }
                if (endTime > urlsNanoTiming.endTime) {
                    urlsNanoTiming.endTime = endTime;
                }
            }
            System.out.printf("UrlReaderSupplier #%d done %d/%d\n", id, startTime, endTime);
        } catch (IOException e) {
            System.out.printf("UrlReaderSupplier: exception with: '%s'\n", entry.getKey().toString());
            e.printStackTrace();
        }
    }
}
