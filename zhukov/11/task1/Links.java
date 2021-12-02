package task1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

import static sun.swing.SwingUtilities2.submit;

public class Links {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Collection<String> links = new CopyOnWriteArrayList<>();
       /* links.add("https://220vk.com/6hands");
        links.add("https://2kindsofpeople.tumblr.com/");*/
        links.add("http://5secondfilms.com/");
        links.add("https://www.midomi.com/");
         links.add("https://www.airpano.com/");
        links.add("http://astronaut.io/");
        links.add("http://billionbirthday.com/");
        links.add("https://www.caffeineinformer.com/death-by-caffeine");
        links.add("https://www.calligraphr.com/en/");
        links.add("http://clicktoremove.com/");
         links.add("http://copout.me/");
        links.add("https://www.death-clock.org/");
        links.add("https://www.diffchecker.com/");
        links.add("https://dvprogram.state.gov/");
        links.add("https://dvtry.com/");
        links.add("https://www.eatthismuch.com/");
        links.add("http://www.essaytyper.com/");
        links.add("https://www.expatistan.com/cost-of-living");
        links.add("https://fires.ru/");
        links.add("https://fixmyspeakers.com/");

        //df.now
/*
        StringBuilder sb = new StringBuilder();
        long bytes = 0 ;
        for (String link:links) {
            sb.append("===== НАЧАЛО САЙТА "+link+" ======\n");
            try(InputStream o = new URL(link).openStream()){
                int firstByte = o.read();
                while( o.read() !=-1){
                    bytes++;
                    firstByte = o.read();
                    sb.append((char)firstByte);
                }
            }
            sb.append("===== КОНЕЦ САЙТА "+link+" ======\n");
        }

        long calculatingTime =   TimeUnit.SECONDS.convert( System.nanoTime() - start, TimeUnit.NANOSECONDS);
        System.out.println("It took "+ calculatingTime +" sec. ");
        System.out.println("Weight "+ bytes +" bytes ");

        File file = new File("sequential.txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));

 */
        StraightSync ss = new StraightSync(links);
        ss.run();


        final long  start = System.nanoTime();

        final ExecutorService es = Executors.newFixedThreadPool(20);

        long startTime = System.nanoTime();

        Iterator<String> iterator = links.iterator();
        Map<String,Future<StringBuilder>> dataResult = new HashMap<>();
        while(iterator.hasNext()) {

            String link = iterator.next();
            int i = 0;
              Future<StringBuilder> res =  es.submit(() -> {

                  StringBuilder sb = new StringBuilder();
                  try (InputStream inputStream = new URL(link).openStream()) {

                    int firstByte = inputStream.read();
                    while (inputStream.read() != -1) {

                        firstByte = inputStream.read();
                        sb.append((char) firstByte);
                    }
                }
                  return sb;
            });
              dataResult.put(link,res);
        }
        es.shutdown();

        StringBuilder res = new StringBuilder();
        for (String link:links) {
            res.append("===== НАЧАЛО САЙТА " + link + " ======\n");
            res.append(dataResult.get(link).get().toString());
            res.append("===== КОНЕЦ САЙТА " + link + " ======\n");
        }

        File file = new File("parallel.txt");
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(res.toString().getBytes(StandardCharsets.UTF_8));
        }

        long calculatingTime =   TimeUnit.SECONDS.convert( System.nanoTime() - start, TimeUnit.NANOSECONDS);
        System.out.println("It took "+ calculatingTime +" sec. " + file.length());
        //System.out.println("Weight "+ bytes +" bytes ");


    }
}
