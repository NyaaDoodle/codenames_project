package engine.gameinstance;

import engine.gamestructure.Team;

import java.util.Objects;

public class WordCard {
    private final String word;
    private final Team team;
    private final int index;
    private final boolean isBlackWord;
    private boolean found = false;

    public WordCard(String word, Team team, int index, boolean isBlackWord) {
        this.word = word;
        this.team = team;
        this.index = index;
        this.isBlackWord = isBlackWord;
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

    public boolean isBlackWord() { return isBlackWord; }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCard wordCard = (WordCard) o;
        return Objects.equals(getWord(), wordCard.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getWord());
    }
}
