package engine.gamestructure;

import java.util.Collections;
import java.util.List;

public class GameStructureData {
    private final Words words;
    private final Board board;
    private final List<Team> teams;
    public GameStructureData(GameStructure gameStructure) {
        this.words = gameStructure.getWords();
        this.board = gameStructure.getBoard();
        this.teams = gameStructure.getTeams();
    }

    public Words getWords() {
        return new Words(words);
    }

    public Board getBoard() {
        return new Board(board);
    }

    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }
}
