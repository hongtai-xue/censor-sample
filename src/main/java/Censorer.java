import java.io.Serializable;

public class Censorer implements Serializable {
    public Censorer() {
    }

    String bleep(String headline, String word) {
        if (headline.startsWith(word)) {
            headline = headline.replaceFirst(word, genMask(word.length()));
        }
        return headline;
    }

    String genMask(int length) {
        String result = "";
        for (int i = 0; i < length; i++)
            result += "*";
        return result;
    }
}