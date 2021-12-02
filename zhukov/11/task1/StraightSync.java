package task1;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class StraightSync {

    Collection<String>  links;

    public StraightSync(Collection<String>  links){
        this.links = links;
    }

    void run() throws IOException {
        final long  start = System.nanoTime();
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
    }
}
