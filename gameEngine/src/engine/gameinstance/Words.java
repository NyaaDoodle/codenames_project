package engine.gameinstance;

import java.util.Collections;
import java.util.List;

public class Words {
    private List<String> gameWords;
    private List<String> blackWords;

    public Words(List<String> gameWords, List<String> blackWords) {
        this.gameWords = gameWords;
        this.blackWords = blackWords;
    }

    public List<String> getGameWords() {
        return Collections.unmodifiableList(gameWords);
    }

    public void setGameWords(List<String> gameWords) {
        this.gameWords = gameWords;
    }

    public List<String> getBlackWords() {
        return Collections.unmodifiableList(blackWords);
    }

    public void setBlackWords(List<String> blackWords) {
        this.blackWords = blackWords;
    }
}
