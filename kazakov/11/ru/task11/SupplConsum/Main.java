package ru.task11.SupplConsum;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

class UrlsNanoTiming {
    public long startTime = Long.MAX_VALUE;
    public long endTime = 0;
}

public class Main {
    final static LinkedHashMap<URL, String> urls = new LinkedHashMap<>();

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
            urls.put(new URL("https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html"), null);
            urls.put(new URL("https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html#join--"), null);

            //  замерим вермя на параллельную загрузку:
            UrlsNanoTiming urlsNanoTiming = new UrlsNanoTiming();
            ////////////////////// reading/writing in parallel, Suppliers/Consumer approach: ///////////////////////
            final UrlConsumer urlWriterConsumer = new UrlConsumer("parallel.txt", urls);
            Thread t = new Thread(urlWriterConsumer);
            t.start();
            //  запускаем suppliers:
            for (Map.Entry<URL, String> entry : urls.entrySet()) {
                new Thread(new UrlSupplier(entry, urlWriterConsumer, urlsNanoTiming)).start();
            }

            //  дожидаемся потока чтобы правильно замерить время загрузки ulrs:
            t.join();
            /*
            System.out.printf("supplier/consumer read/write of: %durls, total amount of %dbytes %d/%d\n",
                    urls.size(), urls.values().stream().mapToInt(String::length).sum(),
                    urlsNanoTiming.startTime , urlsNanoTiming.endTime);
             */
            System.out.printf("supplier/consumer read/write of: %durls, total amount of %dbytes took: %.3fsec.\n",
                    urls.size(), urls.values().stream().mapToInt(String::length).sum(), (urlsNanoTiming.endTime - urlsNanoTiming.startTime) / 1e9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
