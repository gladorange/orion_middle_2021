package task1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> links = new ArrayList<>();
        /* links.add("https://220vk.com/6hands");
        links.add("https://2kindsofpeople.tumblr.com/");*/
        links.add("http://5secondFilms.com/");
        links.add("https://www.midomi.com/");
        links.add("https://www.airpano.com/");
        links.add("http://astronaut.io/");
        links.add("http://billionbirthday.com/");

        UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier(  );
        urlContentQuantifier.countCharsInSites(links);
    }
}
