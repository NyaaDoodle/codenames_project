package engine.gamestructure;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GameStructure {
    private final Words words;
    private final Board board;
    private final Set<Team> teams;

    public GameStructure(Words words, Board board, Set<Team> teams) {
        this.words = words;
        this.board = board;
        this.teams = teams;
    }

    public Words getWords() {
        return words;
    }

    public Board getBoard() { return board; }

    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams);
    }

    public int getTotalCardsInGame() {
        return board.getCardCount() + board.getBlackCardCount();
    }

    @Override
    public String toString() {
        return "GameStructure{" +
                "words=" + words +
                ", board=" + board +
                ", teams=" + teams +
                '}';
    }
}
