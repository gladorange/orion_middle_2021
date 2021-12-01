package task1;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlContentQuantifierTest {

    @Test
    public void countChars() throws IOException {

        List<String> contents = new ArrayList<>();
        contents.add("<html>");
        UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier();

        Assert.assertEquals( "{t=1, h=1, l=1, m=1}",urlContentQuantifier.countCharsInList(contents).toString(),"{t=1, h=1, l=1, m=1}");

    }

    @Test
    public void upCaseChars() throws IOException {

        List<String> contents = new ArrayList<>();
        contents.add("<Html>");
        UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier();
        Map<Character,Long> result = urlContentQuantifier.countCharsInList(contents);

        Set<Character> d = result.keySet();
        Long c =   d.stream().filter(symbol->{
                    Pattern pattern = Pattern.compile("А-ЯA-Z");
                    Matcher matcher = pattern.matcher(symbol.toString());
                    return matcher.find();})
                .count();

        Assert.assertEquals(0, c,0 );

    }

    @Test
    public void yoChars() throws IOException {

        List<String> contents = new ArrayList<>();
        contents.add("Ё-моё");
        UrlContentQuantifier urlContentQuantifier = new UrlContentQuantifier();
        Map<Character,Long> result = urlContentQuantifier.countCharsInList(contents);
        System.out.println(result);
        Set<Character> d = result.keySet();
        Long c =   d.stream().filter(symbol->{
                    Pattern pattern = Pattern.compile("[Ёё]");
                    Matcher matcher = pattern.matcher(symbol.toString());
                    return matcher.find();})
                .count();

        Assert.assertEquals(0, c,0 );

    }
}