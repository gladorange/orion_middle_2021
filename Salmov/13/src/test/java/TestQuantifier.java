import lection13.task1.SiteNotAvailableException;
import lection13.task1.UrlContentQuantifier;
import lection13.task1.UrlContentReceiver;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestQuantifier {

    @Test
    public void testLettersRegistr() throws SiteNotAvailableException {
        UrlContentReceiver receiver = new UrlContentReceiver() {
            @Override
            public String receiveURLContents(List<String> links) {
                return "АаААаАа";
            }
        };
        UrlContentQuantifier quantifier = new UrlContentQuantifier(receiver);
        Map<Character,Long> map = quantifier.qauntifySites(new ArrayList<>());
        assertThat(map, hasEntry('а',7L) );
    }

    @Test
    public void testSpecialSymbols() throws SiteNotAvailableException {
        UrlContentReceiver receiver = new UrlContentReceiver() {
            @Override
            public String receiveURLContents(List<String> links) {
                return "<%& А а А";
            }
        };
        UrlContentQuantifier quantifier = new UrlContentQuantifier(receiver);
        Map<Character,Long> map = quantifier.qauntifySites(new ArrayList<>());
        assertTrue("We should only count 3 letters 'a' but we have:\n"+map,
                (map.size()==1) && map.containsKey('а') && map.get('а')==3L);
    }

    @Test
    public void testLetterYoLogic() throws SiteNotAvailableException {
        UrlContentReceiver receiver = mock(UrlContentReceiver.class);
        when(receiver.receiveURLContents(new ArrayList<>())).thenReturn("Ее Ёё Ё");

        UrlContentQuantifier quantifier = new UrlContentQuantifier(receiver);
        Map<Character,Long> map = quantifier.qauntifySites(new ArrayList<>());
        assertThat(map, hasEntry('е',5L) );
    }

    @Test(expected = SiteNotAvailableException.class)
    public void testNotAvailableException() throws SiteNotAvailableException {
        UrlContentReceiver receiver = mock(UrlContentReceiver.class);
        when(receiver.receiveURLContents(new ArrayList<>())).thenReturn(null);

        UrlContentQuantifier quantifier = new UrlContentQuantifier(receiver);
        Map<Character,Long> map = quantifier.qauntifySites(new ArrayList<>());
    }
}
