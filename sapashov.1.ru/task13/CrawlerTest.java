package task13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;

public class CrawlerTest {

    List<String> words;
    Crawler crawler;

    @BeforeEach
    void setUp() {
        crawler = new Crawler();
        words = new ArrayList();

    }

    @Test
    void throwIfSiteIsNotAvailable() {
        words.add("wrong_link");
        Assertions.assertThrows(Exception.class, () -> crawler.getSymbols(words));
    }

}
