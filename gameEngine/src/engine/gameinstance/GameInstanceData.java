package engine.gameinstance;

import java.util.Collections;
import java.util.List;

public class GameInstanceData {
    private final Words words;
    private final Board board;
    private final List<Team> teams;
    public GameInstanceData (GameInstance gameInstance) {
        this.words = gameInstance.getWords();
        this.board = gameInstance.getBoard();
        this.teams = gameInstance.getTeams();
    }

    public Words getWords() {
        return words;
    }

    public Board getBoard() {
        return board;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
