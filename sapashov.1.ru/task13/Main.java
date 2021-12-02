package task13;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Crawler crawler = new Crawler();
        UrlContentQuantifier contentQuantifier = new UrlContentQuantifier(crawler);

        List<String> links = new LinkedList<>();
        String link1 = "https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html";
        String link2 = "https://docs.oracle.com/javase/tutorial/index.html";
        String link3 = "https://docs.oracle.com/javase/tutorial/getStarted/index.html";
        String link4 = "https://docs.oracle.com/javase/tutorial/java/index.html";
        String link5 = "https://docs.oracle.com/javase/tutorial/essential/index.html";
        String link6 = "https://docs.oracle.com/javase/tutorial/collections/index.html";
        String link7 = "https://docs.oracle.com/javase/tutorial/datetime/index.html";
        String link8 = "https://docs.oracle.com/javase/tutorial/deployment/index.html";
        String link9 = "http://javaway.info/kak-razvernut-stroku-zadom-naperyod/";
        String link10 = "http://javaway.info/e-notty-chut-bolshe-chem-prosto-bloknot-na-android/";

        links.add(link1);
        links.add(link2);
        links.add(link3);
        links.add(link4);
        links.add(link5);
        links.add(link6);
        links.add(link7);
        links.add(link8);
        links.add(link9);
        links.add(link10);
        Map<Character, Long> characterLongMap = contentQuantifier.countRusEngSymbols(links);

        System.out.println(characterLongMap);


    }

}
