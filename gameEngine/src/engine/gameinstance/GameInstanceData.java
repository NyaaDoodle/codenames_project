package engine.gameinstance;

import engine.gamestructure.Board;
import engine.gamestructure.Team;

import java.util.List;
import java.util.Map;

public class GameInstanceData {
    private final List<Team> teams;
    private final Board board;
    private final List<WordCard> words;
    private final Hint currentHint;
    private final Map<Team, Integer> teamToScore;

    public GameInstanceData(GameInstance gameInstance) {
        this.teams = gameInstance.getTeams();
        this.board = gameInstance.getBoard();
        this.words = gameInstance.getWords();
        this.currentHint = gameInstance.getCurrentHint();
        this.teamToScore = gameInstance.getTeamToScore();
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Board getBoard() {
        return board;
    }

    public List<WordCard> getWords() {
        return words;
    }

    public Hint getCurrentHint() {
        return currentHint;
    }

    public Map<Team, Integer> getTeamToScore() {
        return teamToScore;
    }
}
