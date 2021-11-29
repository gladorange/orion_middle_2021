package lection13.task1;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UrlContentQuantifier {
    final UrlContentReceiver receiver;

    public UrlContentQuantifier(UrlContentReceiver receiver) {
        this.receiver = receiver;
    }

    public Map<Character, Long> qauntifySites(List<String> links) throws SiteNotAvailableException {
        String content = receiver.receiveURLContents(links);
        if(content == null)
            throw new SiteNotAvailableException();
        content = content.replaceAll("[^a-zA-Zа-яА-Я0-9ёЁ]","");
        return content.chars()
                .map(Character::toLowerCase)
                .map(c->(c=='ё')?'е':c)
                .mapToObj(in -> (char) in)
                .collect(groupingBy(s->s, counting()));
    }
}
