package http;

import java.io.*;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class HttpLoader {
    public void loadToFile(File file, CopyOnWriteArrayList<URL> urls) throws IOException {
        System.out.println("Загрузка URL начата...");
        long startTime = System.currentTimeMillis();
        try(OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, false))){
            loadUrlsToStream(urls, outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Загрузка URL завершена");
        long endTime = System.currentTimeMillis();
        System.out.printf("Загрузка заняла %s миллисекунд\n", endTime-startTime);
        System.out.printf("Размер файла: %s байт\n", file.length());
    }

    protected abstract void loadUrlsToStream(CopyOnWriteArrayList<URL> urls, OutputStream outputStream) throws IOException;

    protected void loadUrl(URL url, OutputStream outputStream) throws IOException {
        String beginSiteString = "===== НАЧАЛО САЙТА "+url.toString()+" ======\n";
        String endSiteString = "===== КОНЕЦ САЙТА "+url.toString()+" ======\n";

        try(InputStream stream = url.openStream()){
            outputStream.write(beginSiteString.getBytes());
            outputStream.write(stream.readAllBytes());
            outputStream.write(endSiteString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
