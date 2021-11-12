import http.HttpLoader;
import http.ParallelHttpLoader;
import http.SequentialHttpLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;

public class Mailn11 {
    public static void main(String[] args) throws IOException {
        CopyOnWriteArrayList<URL> sites = getUrls();

        HttpLoader sequentialHttpLoaderloader = new SequentialHttpLoader();
        System.out.println("Последовательная загрузка:");
        sequentialHttpLoaderloader.loadToFile(new File("sequential.txt"), sites);

        HttpLoader parallelLoader = new ParallelHttpLoader();
        System.out.println("Параллельная загрузка:");
        parallelLoader.loadToFile(new File("parallel.txt"), sites);
    }

    private static CopyOnWriteArrayList<URL> getUrls() throws MalformedURLException {
        CopyOnWriteArrayList<URL> sites = new CopyOnWriteArrayList<>();
        sites.add(new URL("https://www.ya.ru/"));
        sites.add(new URL("https://www.google.com/"));
        sites.add(new URL("https://www.youtube.com/"));
        sites.add(new URL("https://www.vk.com/"));
        sites.add(new URL("https://www.instagram.com/?hl=ru"));
        sites.add(new URL("https://www.facebook.com/"));
        sites.add(new URL("https://habr.com/"));
        sites.add(new URL("https://www.facebook.com/"));
        sites.add(new URL("https://1c.ru/"));
        sites.add(new URL("https://disgustingmen.com/"));
        sites.add(new URL("https://www.oracle.com/"));
        sites.add(new URL("https://www.java.com/ru/"));
        sites.add(new URL("https://career.orioninc.ru/"));
        sites.add(new URL("https://nn.hh.ru/"));
        sites.add(new URL("https://learn.javascript.ru/"));
        sites.add(new URL("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0"));
        sites.add(new URL("https://www.kinopoisk.ru/"));
        sites.add(new URL("https://github.com/gladorange/orion_middle_2021/blob/main/_LECTIONS/11/home-work9.txt"));
        sites.add(new URL("https://github.com/"));
        sites.add(new URL("https://about.gitlab.com/"));
        return sites;
    }
}
