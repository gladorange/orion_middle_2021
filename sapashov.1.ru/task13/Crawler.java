package task13;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Crawler {

    public List<String> getSymbols(List<String> links) throws Exception {
        List<String> content = new ArrayList();
        for (String link : links) {
            System.out.printf("%n=========  Begin %s  ========", link);
            try {
                byte[] bytes = new URL(link).openStream().readAllBytes();
                String str = new String(bytes);
                content.add(str);
            } catch (IOException e) {
                throw new Exception("Site not available exception");
            }
            System.out.printf("%n=========  End %s  ========", link);
            System.out.println();
        }
        return content;
    }
}
