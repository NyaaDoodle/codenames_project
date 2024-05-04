package engine.gameinstance;

import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameInstance {
    private final List<Team> teams;
    private final Board board;
    private List<WordCard> words;
    private Hint currentHint;
    private Map<Team, Integer> teamToScore;
    public GameInstance(GameStructure gameStructureData) {
        this.teams = gameStructureData.getTeams();
        this.board = gameStructureData.getBoard();
        // ..................
    }

    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }

    public Board getBoard() {
        return board;
    }

    public Hint getCurrentHint() {
        return currentHint;
    }

    public void setCurrentHint(Hint currentHint) {
        this.currentHint = currentHint;
    }

    public List<WordCard> getWords() {
        return Collections.unmodifiableList(words);
    }

    public Map<Team, Integer> getTeamToScore() {
        return Collections.unmodifiableMap(teamToScore);
    }
}
