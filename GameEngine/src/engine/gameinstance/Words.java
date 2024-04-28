package engine.gameinstance;

import java.util.List;

public class Words {
    private List gameWords;
    private List blackWords;

    public Words(List gameWords, List blackWords) {
        this.gameWords = gameWords;
        this.blackWords = blackWords;
    }

    public List getGameWords() {
        return gameWords;
    }

    public void setGameWords(List gameWords) {
        this.gameWords = gameWords;
    }

    public List getBlackWords() {
        return blackWords;
    }

    public void setBlackWords(List blackWords) {
        this.blackWords = blackWords;
    }
}
