package ru.task13;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class SiteNotAvailableException extends IOException {
    public SiteNotAvailableException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

public class UrlLoader {

    //  https://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code
    public String loadUrl(URL sss) throws SiteNotAvailableException {
        try (Scanner scanner = new Scanner(sss.openStream(),
                StandardCharsets.UTF_8.toString()))
        {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (Exception e) {
            throw new SiteNotAvailableException(String.format("URL по адресу: '%s' недоступен", sss), e);
        }
    }

}

