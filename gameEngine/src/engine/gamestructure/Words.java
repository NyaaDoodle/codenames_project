package engine.gamestructure;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Words {
    private Set<String> gameWords;
    private Set<String> blackWords;

    public Words(Set<String> gameWords, Set<String> blackWords) {
        this.gameWords = gameWords;
        this.blackWords = blackWords;
    }

    public Words(Words copyWords) {
        this.gameWords = copyWords.gameWords;
        this.blackWords = copyWords.blackWords;
    }

    public List<String> getGameWords() {
        return Collections.unmodifiableList(gameWords);
    }

    public void setGameWords(Set<String> gameWords) {
        this.gameWords = gameWords;
    }

    public List<String> getBlackWords() {
        return Collections.unmodifiableList(blackWords);
    }

    public void setBlackWords(Set<String> blackWords) {
        this.blackWords = blackWords;
    }
}
