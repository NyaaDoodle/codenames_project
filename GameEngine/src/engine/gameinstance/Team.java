package engine.gameinstance;

public class Team {
    String name;
    int cardCount;
    int currentScore;

    public Team(String name, int cardCount, int currentScore) {
        this.name = name;
        this.cardCount = cardCount;
        this.currentScore = currentScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
