package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();
        urls.add("https://yandex.ru/");
        urls.add("https://ru.wikipedia.org/wiki/%D0%81%D0%BB%D0%BA%D0%B0_(%D0%BF%D0%B5%D0%B2%D0%B8%D1%86%D0%B0)");
        UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier(urls);
        Map<Character, Long> result = urlContentQuantifier.quantify();

        System.out.println(new TreeMap<>(result));
    }
}
