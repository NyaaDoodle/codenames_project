package engine.gameinstance;

import engine.gamestructure.Team;

import java.util.Objects;

public class WordCard {
    private final String word;
    private final Team team;
    private final boolean isBlackWord;
    private boolean found = false;

    public WordCard(String word, Team team, boolean isBlackWord) {
        this.word = word;
        this.team = team;
        this.isBlackWord = isBlackWord;
    }

    public String getWord() {
        return word;
    }

    public Team getTeam() {
        return team;
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

    @Override
    public String toString() {
        return "WordCard{" +
                "word='" + word + '\'' +
                ", team=" + team +
                ", isBlackWord=" + isBlackWord +
                ", found=" + found +
                '}';
    }
}
