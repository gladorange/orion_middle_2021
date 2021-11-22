package test.example;

import example.UrlContentQuantifier;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class UrlContentQuantifierTest {

    @Test
    public void testHelloWorld() {
        UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier(List.of("http://wikipedia.com"), new UrlContentQuantifier.UrlContentExtractor() {
            @Override
            public String extract(String url) {
                return "Hello World!";
            }
        });

        Map<Character, Long> result = urlContentQuantifier.quantify();


        TreeMap<Character, Long> testResult = new TreeMap<>();
        testResult.put('h', 1L);
        testResult.put('e', 1L);
        testResult.put('l', 3L);
        testResult.put('o', 2L);
        testResult.put('w', 1L);
        testResult.put('r', 1L);
        testResult.put('d', 1L);

        Assert.assertEquals(new TreeMap<>(result), testResult);
    }

    @Test
    public void testCyrillicWithSymbols() {
        UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier(List.of("http://wikipedia.com"), new UrlContentQuantifier.UrlContentExtractor() {
            @Override
            public String extract(String url) {
                return "С днём рождения!))";
            }
        });

        Map<Character, Long> result = urlContentQuantifier.quantify();

        TreeMap<Character, Long> testResult = new TreeMap<>();
        testResult.put('с', 1L);
        testResult.put('д', 2L);
        testResult.put('н', 2L);
        testResult.put('е', 2L);
        testResult.put('м', 1L);
        testResult.put('р', 1L);
        testResult.put('о', 1L);
        testResult.put('ж', 1L);
        testResult.put('и', 1L);
        testResult.put('я', 1L);

        Assert.assertEquals(new TreeMap<>(result), testResult);
    }
}
