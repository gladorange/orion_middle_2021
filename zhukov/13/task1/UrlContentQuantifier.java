package task1;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UrlContentQuantifier {

    private int symbol;

    private String matchPattern = "[a-zA-ZА-Яа-яЁё0-9]";
    public UrlContentQuantifier(){
    }

    public void setMatchPattern(String matchPattern) {
        this.matchPattern = matchPattern;
    }

    public Map<Character,Long> countCharsInSites(List<String> links) throws IOException {


        List<String> sitesContent = getSitesContent(links);
        final Map<Character,Long> collect = countCharsInList(sitesContent);

        //System.out.println(collect);
        return collect;

    }

    public Map<Character,Long> countCharsInList(List<String>  content ) throws IOException {

        final Map<Character,Long> collect =
                Stream.of( content.toArray(new String[content.size()]) )
                        .flatMapToInt(string -> string.toLowerCase().chars())
                        .mapToObj(in->Character.valueOf((char) in) )
                        .filter(filterByPattern(this.matchPattern))
                        .map(sym -> sym.toString().matches("[ёЁ]") ? 'е' : sym)
                        .collect(Collectors.groupingBy(s->s,Collectors.counting()));
        return  collect;
    }

    @NotNull
    private List<String> getSitesContent(List<String> links) throws IOException {
        List<String> sitesContent  = new ArrayList<>();
        for (String link:links) {
            StringBuilder sb = new StringBuilder();

            try(InputStream o = new URL(link).openStream()){
                int firstByte = o.read();

                while( o.read() !=-1){
                    firstByte = o.read();
                    sb.append((char)firstByte);
                }
            }
            sitesContent.add(sb.toString());
        }
        return sitesContent;
    }

    @NotNull
    private Predicate<Character> filterByPattern(String searchpattern) {
        return symbol->{
            Pattern pattern = Pattern.compile(searchpattern);
            Matcher matcher = pattern.matcher(symbol.toString());
            return matcher.find();
                };
    }
}
