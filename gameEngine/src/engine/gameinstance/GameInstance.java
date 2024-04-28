package engine.gameinstance;

import java.util.Collections;
import java.util.List;

public class GameInstance {
    private Words words;
    private Board board;
    private List<Team> teams;

    public GameInstance() {}

    public GameInstance(Words words, Board board, List<Team> teams) {
        this.words = words;
        this.board = board;
        this.teams = teams;
    }

    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public Board getBoard() {
        return board;
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
