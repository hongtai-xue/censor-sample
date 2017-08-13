import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CensorerTest {
    private final Censorer censorer = new Censorer();

    @Test
    public void noCensor(){
        assertEquals("some headline", censorer.bleep("some headline", "other"));
    }

    @Test
    public void censorFirstWord() {
        assertEquals("***** world", censorer.bleep("hello world", "hello"));

    }
}