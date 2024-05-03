package engine.gameinstance;

import engine.gamestructure.Team;

public class WordCard {
    private final String word;
    private final Team team;
    private final int index;
    private boolean found = false;

    public WordCard(String word, Team team, int index) {
        this.word = word;
        this.team = team;
        this.index = index;
    }

    public String getWord() {
        return word;
    }

    public Team getTeam() {
        return team;
    }

    public int getIndex() {
        return index;
    }

    public boolean isFound() {
        return found;
    }
    public void setFound(boolean found) {
        this.found = found;
    }
}
