package ru.task13;

import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
Напишите Unit-tests, которые:
- Работают изолированно (т.е. без доступа к интернету)
- проверяют региср букв
* - проверяют отсутствие спецсимволов, например "<html>" => {h=>1,t=>1,m=>1,l=1}
* - проверяют спец.логику с буквой Ё
* - проверяют, что исключение выкидывается.
 */
class UrlReaderTest {
    //@Mock
    UrlLoader urlLoader;
    UrlContentQuantifier urlContentQuantifier;

    @BeforeEach
    public void setUp() {
        urlLoader = mock(UrlLoader.class);
        this.urlContentQuantifier = new UrlContentQuantifier(urlLoader);
    }

    //  - проверяют отсутствие спецсимволов, например "<html>" => {h=>1,t=>1,m=>1,l=1}
    //  - проверяют регистр букв
    @Test
    void testSpecialChars() throws SiteNotAvailableException, MalformedURLException {

        byte[] array = new byte[1000000];
        new Random().nextBytes(array);
        String RANDOM_CHARS_STRING = new String(array, StandardCharsets.UTF_8);
        //System.out.print(RANDOM_CHARS_STRING);

        List<URL> urls = new ArrayList<>();
        urls.add(new URL("http://www.test-site-with-special-chars.ru"));
        when(urlLoader.loadUrl(urls.get(0))).thenReturn(RANDOM_CHARS_STRING);

        Map<Character, Long> result = urlContentQuantifier.quantifyUrls(urls);
        assertEquals(0, countSpecialChars(result), "check for Special characters failed");
        assertEquals(0, countUppercase(result), "check for Uppercase failed");
    }

    Long countSpecialChars(Map<Character, Long> map) {
        return map.entrySet().stream()
                .filter(s -> !Character.isDigit(s.getKey()) && !Character.isLetter(s.getKey()))
                .count();
    }

    Long countUppercase (Map<Character, Long> map) {
        return map.entrySet().stream()
                .filter(s -> Character.isUpperCase(s.getKey()))
                .count();
    }

    //  - проверяют спец.логику с буквой Ё
    @Test
    void testYeeeeyChars()  throws SiteNotAvailableException, MalformedURLException  {
        List<URL> urls = new ArrayList<>();
        urls.add(new URL ("http://www.test-site-with-Yeeeeeeeey.ru"));

        when(urlLoader.loadUrl( urls.get(0))).thenReturn("ёёёёЁЁЁЁЁЁЁЁЁЁЁЁЁЁЁЁЁЁЁЁёёёеееееее");
        Map<Character, Long> result = urlContentQuantifier.quantifyUrls(urls);
        assertNull(result.get('Ё'), "check for Ё letter failed");
        assertNull(result.get('ё'), "check for ё letter failed");
        assertNotEquals(null, result.get('е'), "check for ё letter failed");
    }

    //  - проверяют региср букв
    @Test
    public void testUpperLowercase() throws SiteNotAvailableException, MalformedURLException {
        List<URL> urls = new ArrayList<>();
        urls.add(new URL ("http://www.test-site-with-AAAaaa.ru"));
        when(urlLoader.loadUrl( urls.get(0))).thenReturn("AAAaaa");
        Map<Character, Long> result = urlContentQuantifier.quantifyUrls(urls);
        assertEquals(6, result.get('a'), "check for Lowercase failed");
        assertNull(result.get('A'), "check for Uppercase failed");
    }

    //  - проверяют, что исключение выкидывается.
    @Test
    public void testExceptionThrown() throws SiteNotAvailableException, MalformedURLException {
        List<URL> urls = new ArrayList<>();
        urls.add(new URL ("http://www.swim-rt2.ru"));
        when(urlLoader.loadUrl( urls.get(0))).thenThrow(SiteNotAvailableException.class);
        assertThrows(SiteNotAvailableException.class, () -> urlContentQuantifier.quantifyUrls(urls));
    }
}

