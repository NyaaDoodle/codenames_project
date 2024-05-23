package engine.gamestructure;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GameStructure {
    private final Words words;
    private final Board board;
    private final List<Team> teams;

    public GameStructure(Words words, Board board, List<Team> teams) {
        this.words = words;
        this.board = board;
        this.teams = teams;
    }

    public Words getWords() {
        return words;
    }

    public Board getBoard() { return board; }

    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
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
