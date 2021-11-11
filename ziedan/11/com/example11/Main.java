package com.example11;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        List<String> links = new ArrayList<>();
        links.add("https://google.com");
        links.add("https://yandex.ru");
        links.add("https://facebook.com");
        links.add("https://avito.ru");
        links.add("https://reddit.com");
        links.add("https://www.orioninc.com/");
        links.add("https://vk.com/");
        links.add("https://youtube.com/");
        links.add("https://vc.ru/");
        links.add("https://twitter.com/");
        links.add("https://wikipedia.org/");
        links.add("https://whatsapp.com/");
        links.add("https://yahoo.com/");
        links.add("https://instagram.com/");
        links.add("https://mail.ru/");
        links.add("https://discord.com/");
        links.add("https://cnn.com/");
        links.add("https://pinterest.com/");
        links.add("https://bing.com/");
        links.add("https://ebay.com/");
        links.add("https://msn.com/");


        loadSequentially(links);
        loadInParallel(links);


    }

    private static void loadSequentially(List<String> links) throws IOException {
        System.out.println("\n=== starting downloading sequentially ===\n");
        LocalDateTime start = LocalDateTime.now();

        List<String> result = new ArrayList<>();
        AtomicInteger totalBytes = new AtomicInteger();
        links.forEach(link -> {
            try (InputStream inputStream = new URL(link).openStream()) {
                byte[] bytes = inputStream.readAllBytes();
                logCountBytesFromLink(bytes, link);

                totalBytes.addAndGet(bytes.length);

                String content = String.format("\n==== НАЧАЛО САЙТА %s ===== \n", link)
                        + new String(bytes, StandardCharsets.UTF_8)
                        + String.format("\n==== КОНЕЦ САЙТА %s ===== \n", link);
                result.add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        Files.write(Paths.get("sequential.txt"), result);

        long durationInSeconds = ChronoUnit.SECONDS.between(start, LocalDateTime.now());
        System.out.printf("Operation \"Sequential\" took %s seconds to finish with %s total bytes %n", durationInSeconds, totalBytes);

    }

    private static void logCountBytesFromLink(byte[] bytes, String link) {
        System.out.printf("%s bytes have been downloaded from %s %n", bytes.length, link);
    }

    private static void loadInParallel(List<String> links) throws IOException {
        System.out.println("=== starting downloading parallel ===");
        LocalDateTime start = LocalDateTime.now();

        ExecutorService executorService = Executors.newFixedThreadPool(links.size());

        AtomicInteger totalBytes = new AtomicInteger(0);

        List<Future<String>> futures = new ArrayList<>();

        links.forEach(link -> {
            Future<String> future = executorService.submit(() -> {
                try (InputStream inputStream = new URL(link).openStream()) {
                    byte[] bytes = inputStream.readAllBytes();
                    logCountBytesFromLink(bytes, link);

                    totalBytes.addAndGet(bytes.length);

                    return String.format("\n==== НАЧАЛО САЙТА %s ===== \n", link)
                            + new String(bytes, StandardCharsets.UTF_8)
                            + String.format("\n==== КОНЕЦ САЙТА %s ===== \n", link);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            });
            futures.add(future);
        });

        List<String> result = futures.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        executorService.shutdown();

        Files.write(Paths.get("parallel.txt"), result);

        long durationInSeconds = ChronoUnit.SECONDS.between(start, LocalDateTime.now());
        System.out.printf("Operation \"Parallel\" took %s seconds to finish with %s total bytes %n", durationInSeconds, totalBytes);
    }
}
