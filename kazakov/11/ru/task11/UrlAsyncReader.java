package ru.task11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class UrlAsyncReader implements Runnable {
    final Map.Entry <URL, String> entry;
    final CountDownLatch latch;

    public UrlAsyncReader(Map.Entry <URL, String> entry  , CountDownLatch latch) {
        this.entry = entry;
        this.latch = latch;
    }

    //  загрузим наш url в буфер:
    void loadUrl() throws IOException {

        String inputLine;
        final StringBuilder urlContent = new StringBuilder();
        final BufferedReader in = new BufferedReader(new InputStreamReader(entry.getKey().openStream()));
        while ((inputLine = in.readLine()) != null) {
//            System.out.println(inputLine);
            urlContent.append(inputLine);
        }
        in.close();
        entry.setValue(urlContent.toString());

        latch.countDown();
    }

    @Override
    public void run() {

        try {
            loadUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

