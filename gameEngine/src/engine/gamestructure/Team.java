package engine.gamestructure;

public class Team {
    private final String name;
    private final int startingCardCount;

    public Team(String name, int startingCardCount) {
        this.name = name;
        this.startingCardCount = startingCardCount;
    }

    public String getName() {
        return name;
    }

    public int getStartingCardCount() {
        return startingCardCount;
    }
}
