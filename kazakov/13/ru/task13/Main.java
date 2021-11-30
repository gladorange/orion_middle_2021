
package ru.task13;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try (UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier(new UrlLoader())) {

            List<URL> urls = new ArrayList<>();
            urls.add(new  URL("https://greenpeacefund.org"));
            urls.add(new URL("http://www.swim-rt.ru"));

            //java.util.Map<Character, Long> mapa =
                    urlContentQuantifier.quantifyUrls(urls);
            //urlContentQuantifier.getCountSpecialChars(mapa).forEach((key, value) -> System.out.printf("%s : %d\n", key, value));
            //System.out.println(urlContentQuantifier.countSpecialChars(mapa));
            System.out.println("Hello World from lesson 13!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
