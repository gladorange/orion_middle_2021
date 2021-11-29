package ru.task13;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.UnicodeBlock.*;

/*
    Рекомендации:
    2. В UrlContentQuantifier добавьте зависимость на доплонительный класс, который будет получать содрежимое ссылок
    3. Используйте технику подмены зависимостей, чтобы отдавать и считать нужный контент.
 */
public class UrlContentQuantifier implements AutoCloseable {
    UrlLoader urlReader;

    public UrlContentQuantifier(UrlLoader urlReader) {
        this.urlReader = urlReader;
    }

    Map<Character, Long> quantifyUrls(List<URL> urls) throws SiteNotAvailableException {
        Map<Character, Long> quantiMap = new HashMap<>();

        for (URL url : urls) {
            String bufferUrl = urlReader.loadUrl(url);
            quantiMap = addQuantiMaps(quantiMap, Stream.of(bufferUrl)
                    .flatMapToInt(String::chars)
                    .mapToObj(in -> (char) toLowercaseAndYeah(in))
                    .filter(UrlContentQuantifier::isLowercaseOrRussianOrDigit)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        }
        return quantiMap;
    }

    //  merge quantiMap results:
    Map<Character, Long> addQuantiMaps(Map<Character, Long> map, Map<Character, Long> addMap) {
        return Stream.of(map, addMap)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum));
    }

    public int toLowercaseAndYeah(int ch) {

        ch = Character.toLowerCase(ch);
        return ch == 'ё' ? 'е' : ch;
    }

    public static boolean isLowercaseOrRussianOrDigit(int ch) {
        return (ch >= 'а' && ch <= 'я' && Character.UnicodeBlock.of(ch) == CYRILLIC) ||
                ((Character.isDigit(ch) || Character.isLetter(ch)) && Character.UnicodeBlock.of(ch) == BASIC_LATIN);
    }

    @Override
    public void close() {

    }
}

