package example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UrlContentQuantifier {
    private List<String> urls;
    private UrlContentExtractor extractor;

    public UrlContentQuantifier(List<String> urls, UrlContentExtractor extractor) {
        this.urls = urls;
        this.extractor = extractor;
    }

    public UrlContentQuantifier(List<String> urls) {
        this.urls = urls;
        this.extractor = new UrlContentExtractor();

    }

    public static class UrlContentExtractor {

        public String extract(String url) {
            try (InputStream is = new URL(url).openStream()) {
                return new String(is.readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }



    public Map<Character, Long> quantify() {
        return urls.stream()
                .flatMap(url -> extractor.extract(url).chars().mapToObj(i -> (char) i))
                .filter(c -> c.toString().matches("[A-Za-zА-Яа-яёЁ0-9]"))
                .map(c -> c.toString().matches("[ёЁ]") ? 'е' : c)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

}
