package task13;

import java.util.*;

public class UrlContentQuantifier {

    private final Crawler crawler;

    public static final String ENG_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String RUS_ALPHABET = "йцукёенгшщзхъэждлорпавыфячсмитьбю";

    public UrlContentQuantifier(Crawler crawler) {
        this.crawler = crawler;
    }


    public Map<Character, Long> countRusEngSymbols(List<String> links) throws Exception {
        Map<Character, Long> symbols = new HashMap<>();
        List<String> stringList = crawler.getSymbols(links);
        for(String string : stringList){
            for(char c : string.toLowerCase()
                    .replaceAll("\\s+","")
                    .replaceAll("ё", "е")
                    .toCharArray()){
                symbols.merge(c, 1L, Long::sum);
            }
        }
        removeSpecialSymbols(symbols);
        return symbols;
    }

    public void removeSpecialSymbols(Map<Character, Long> characterLongMap) {
        Iterator<Map.Entry<Character, Long>> iter = characterLongMap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<Character, Long> entry = iter.next();
            if(!ENG_ALPHABET.contains(entry.getKey().toString()) && !RUS_ALPHABET.contains(entry.getKey().toString()) ){
                iter.remove();
            }
        }
    }


}
