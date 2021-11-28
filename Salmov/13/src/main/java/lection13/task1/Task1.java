package lection13.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) throws SiteNotAvailableException {
        UrlContentReceiver receiver = new UrlContentReceiver();
        UrlContentQuantifier quantifier = new UrlContentQuantifier(receiver);
        System.out.println( quantifier.qauntifySites(new ArrayList<>(
                Arrays.asList(
                        "https://habr.com/ru/company/luxoft/blog/157273/",
                        "http://java-online.ru/java-thread.xhtml",
                        "http://java-online.ru/concurrent-collections.xhtml"
                )
            ))
        );
    }
}
