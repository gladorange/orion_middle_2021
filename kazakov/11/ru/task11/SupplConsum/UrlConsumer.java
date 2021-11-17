package ru.task11.SupplConsum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UrlConsumer implements Runnable {
    final String fileName;
    final LinkedHashMap<URL, String> urls;
    //  urlsUnloaded хранит инфо о выгруженных/невыгруженных URLs в файл. по нему мы вычисляем какой следующий URL выгружать:
    final Map<URL, Boolean> urlsUnloaded = new HashMap<>();

    public UrlConsumer(String fileName, LinkedHashMap<URL, String> urls) {
        this.fileName = fileName;
        this.urls = urls;
        //  инициализируем карту не/выгруженных Urls:
        for (Map.Entry<URL, String> entry : this.urls.entrySet()) {
            urlsUnloaded.put(entry.getKey(), false);
        }
    }
    boolean isAllUrlsUnloaded () {
        for (Map.Entry<URL, Boolean> entry : urlsUnloaded.entrySet()) {
            if (!entry.getValue())
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!Thread.interrupted()) {
                    wait();
                    //  got new fresh Url:
                    for (Map.Entry<URL, String> entry : urls.entrySet()) {
                        final String urlContent = entry.getValue();
                        if (urlContent == null) {   //  этот url ещё не загружен - уходим опять в wait()
                            break;
                        }
                        final boolean isUnloaded = urlsUnloaded.get(entry.getKey());
                        if (!isUnloaded) {     //   url загружен но не выгружен в файл - выгружаем его:
                            writeUrlContent(entry.getKey(), entry.getValue());
                            //  устанавливаем флаг 'выгружено' для url:
                            urlsUnloaded.put(entry.getKey(), true);
                        }
                    }
                    if (isAllUrlsUnloaded()) {
                        System.out.println("UrlWriterConsumer: job done, exit");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("UrlWriterConsumer: exiting via interrupt");
        }
    }

    void writeUrlContent(URL url, String urlContent) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("===== НАЧАЛО САЙТА: <%s> ======\n", url.toString()));
        bw.write(urlContent);
        bw.write(String.format("===== КОНЕЦ САЙТА: <%s> ======\n", url.toString()));
        bw.close();
    }
}

