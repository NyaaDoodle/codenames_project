package engine.gamestructure;

import java.util.List;

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
        return teams;
    }

}
