package ru.task11;

import java.io.*;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;


public class ParallelDimensions11 {
    /*
        в этой задаче структура для хранения содержимого URLs является потокобезопасной (разные потоки используют разные
        Entry для доступа/модификации данных, поэтому мы можем использовать обычную  LinkedHashMap<...> , IMHO
        https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
     */
    final static LinkedHashMap<URL, String> urls = new LinkedHashMap<>();
    //final static Map <URL, String>  urls = Collections.synchronizedMap(new LinkedHashMap<>());

    public static void main(String[] args) {

        try {
            //  1. Создайте упорядоченную коллекцию из 20 http ссылок:
            urls.put(new URL("https://fivebooks.com/best-books/best-books-art-crime-noah-charney/"), null);
            urls.put(new URL("http://www.swim-rt.ru"), null);
            urls.put(new URL("https://www.skisport.ru"), null);
            urls.put(new URL("https://en.wikipedia.org/wiki/Running"), null);
            urls.put(new URL("https://www.tanukishop.com/ru/yahoo-auctions/list/vacuum-tube-amplifier-8343"), null);
            urls.put(new URL("https://vk.com/wall-54530371_101"), null);
            urls.put(new URL("https://vk.com/doc12100482_321806885?hash=0c3a0de26d8b08c359"), null);
            urls.put(new URL("https://github.com/gladorange/orion_middle_2021/blob/main/_LECTIONS/11/home-work9.txt"), null);
            urls.put(new URL("https://news.artnet.com/art-world/713210-713210"), null);
            urls.put(new URL("https://regex101.com/r/cO8lqs/1"), null);
            urls.put(new URL("https://en.wikipedia.org/wiki/Never_Let_Me_Go_(novel)"), null);
            urls.put(new URL("https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/"), null);
            urls.put(new URL("https://en.wikipedia.org/wiki/Dracula"), null);
            urls.put(new URL("https://en.wikipedia.org/wiki/The_Girl_with_the_Dragon_Tattoo"), null);
            urls.put(new URL("https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem"), null);
            urls.put(new URL("https://docs.oracle.com/javase/8/docs/api/overview-summary.html"), null);
            urls.put(new URL("https://greenpeacefund.org"), null);
            urls.put(new URL("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html"), null);
            urls.put(new URL("https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html"), null);
            urls.put(new URL("https://docs.oracle.com/javase/8/docs/api/overview-summary.html"), null);
            urls.put(new URL("https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html"), null);

            //  замеряем время на последоват. загрузку URLs:
            long startTime = System.nanoTime();

            for (Map.Entry<URL, String> entry : urls.entrySet()) {
                URL url = entry.getKey();

                //  читаем новый URL:
                StringBuilder inputBuff = new StringBuilder();
                String inputLine;
                final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((inputLine = in.readLine()) != null) {
//                    System.out.println(inputLine);
                    inputBuff.append(inputLine);
                }
                in.close();
                //  добавляем содержимое нового URL в нашу LinkedHashMap:
                entry.setValue(inputBuff.toString());
            }
            System.out.printf("SEQUENTIAL read of: %durls, total amount of %dbytes took: %.3fsec.\n",
                    urls.size(), urls.values().stream().mapToInt(String::length).sum(), (System.nanoTime() - startTime) / 1e9);

            //  4. Запишите содержимое всех сайтов в файл sequential.txt в формате:
            urls.forEach((key, value) -> {
                try {
                    urlFileWrite("sequential.txt", key, value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            //  empty url contents for reuse:
            urls.entrySet().forEach(x -> x.setValue(null));

            ////////////////////// reading in parallel: ///////////////////////
            startTime = System.nanoTime();
            CountDownLatch latch = new CountDownLatch(urls.size());
            //  1. read in fully parallel:
            for (Map.Entry<URL, String> entry : urls.entrySet()) {
                new Thread(new UrlAsyncReader(entry, latch)).start();
            }
            latch.await();
            System.out.printf("PARALLEL read of: %durls, total amount of %dbytes took: %.3fsec.\n",
                    urls.size(), urls.values().stream().mapToInt(String::length).sum(), (System.nanoTime() - startTime) / 1e9);

            //  2. write to file sequentially:
            urls.forEach((key, value) -> {
                try {
                    urlFileWrite("parallel.txt", key, value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void urlFileWrite(String fileName, URL url, String content) throws IOException {
        /*
        4. Запишите содержимое всех сайтов в файл sequential.txt в формате:
===== НАЧАЛО САЙТА <ссылка1> ======
 <содержимое по ссылке>
===== НАЧАЛО САЙТА <ссылка2> ======
        Это важно: Порядок должен быть тем же самым, в котором у вас были упорядочены ссылки в исходной коллекции.
        */
        String headerInfo;
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        headerInfo = String.format("===== НАЧАЛО САЙТА: <%s> ======\n", url.toString());
        bw.write(headerInfo);
        bw.write(content);
        headerInfo = String.format("===== КОНЕЦ САЙТА: <%s> ======\n", url.toString());
        bw.write(headerInfo);
        bw.close();
    }
}

