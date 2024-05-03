package engine.gamestructure;

import java.util.Collections;
import java.util.Set;

public class Words {
    private final Set<String> gameWords;
    private final Set<String> blackWords;

    public Words(Set<String> gameWords, Set<String> blackWords) {
        this.gameWords = gameWords;
        this.blackWords = blackWords;
    }

    public Set<String> getGameWords() {
        return gameWords;
    }

    public Set<String> getBlackWords() {
        return blackWords;
    }
}
