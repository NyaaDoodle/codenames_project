package engine.gamestructure;

public class Team {
    private final String name;
    private final int cardCount;

    public Team(String name, int cardCount) {
        this.name = name;
        this.cardCount = cardCount;
    }

    public String getName() {
        return name;
    }

    public int getCardCount() {
        return cardCount;
    }
}
