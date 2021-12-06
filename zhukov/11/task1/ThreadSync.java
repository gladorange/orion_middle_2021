package task1;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

public class ThreadSync extends Thread{

    String link ;
    long bytes;
    StringBuilder sb ;

    ThreadSync(String link,long bytes, StringBuilder sb ){
        this.link = link;
        this.bytes = bytes;
        this.sb = sb;
    }
    @Override
    synchronized public void run() {
        //super.run();
        sb.append("===== НАЧАЛО САЙТА "+link+" ======\n");
        try(InputStream o = new URL(link).openStream()){
            int firstByte = o.read();

            while( o.read() !=-1){
                bytes++;
                firstByte = o.read();
                sb.append((char)firstByte);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.append("===== КОНЕЦ САЙТА "+link+" ======\n");
    }
}
