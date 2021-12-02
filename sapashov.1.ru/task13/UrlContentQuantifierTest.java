package task13;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
public class UrlContentQuantifierTest {

    @Mock
    Crawler crawler;

    List<String> words;

    UrlContentQuantifier contentQuantifier;

    @BeforeEach
    void setUp() {
        contentQuantifier = new UrlContentQuantifier(crawler);
        words = new ArrayList();

    }


    @Test
    void testDontAddSpecialSymbols() throws Exception {
        when(crawler.getSymbols(words)).thenReturn(words);
        words.add("<html>");
        Map<Character, Long> characterLongMap = contentQuantifier.countRusEngSymbols(words);
        System.out.println(characterLongMap);
        Assert.assertNull("doesn't content key <", characterLongMap.get("<"));
        Assert.assertNull("doesn't content key >", characterLongMap.get(">"));
    }

    @Test
    void dontPassCapitalLettersTest() throws Exception {
        when(crawler.getSymbols(words)).thenReturn(words);
        words.add("ABCDEFghijkАБВГД");
        Map<Character, Long> characterLongMap = contentQuantifier.countRusEngSymbols(words);
        System.out.println(characterLongMap);
        characterLongMap.keySet().forEach( character -> {
            Assertions.assertTrue(!Character.isUpperCase(character));
                }
        );
    }

    @Test
    void YoDontPassTest() throws Exception {
        when(crawler.getSymbols(words)).thenReturn(words);
        words.add("ЁёЁёЁё_ееее");
        Map<Character, Long> characterLongMap = contentQuantifier.countRusEngSymbols(words);
        System.out.println(characterLongMap);
        characterLongMap.keySet().forEach( character -> {
                    Assertions.assertTrue(character != 'Ё' && character != 'ё');
                }
        );
    }
}