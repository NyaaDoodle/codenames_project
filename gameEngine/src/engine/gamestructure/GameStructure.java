package engine.gamestructure;

import java.util.Collections;
import java.util.List;

public class GameStructure {
    private Words words;
    private Board board;
    private List<Team> teams;

    public GameStructure() {}

    public GameStructure(Words words, Board board, List<Team> teams) {
        this.words = words;
        this.board = board;
        this.teams = teams;
    }

    public Words getWords() {
        return new Words(words);
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public Board getBoard() {
        return new Board(board);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
