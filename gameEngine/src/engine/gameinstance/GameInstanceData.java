package engine.gameinstance;

import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameInstanceData {
    private final GameStructure gameStructure;
    private final Set<WordCard> words;
    private final Hint currentHint;
    private final Map<Team, Integer> teamToScore;

    public GameInstanceData(GameInstance gameInstance) {
        this.gameStructure = gameInstance.getGameStructure();
        this.words = gameInstance.getWords();
        this.currentHint = gameInstance.getCurrentHint();
        this.teamToScore = gameInstance.getTeamToScore();
    }

    public GameStructure getGameStructure() { return gameStructure; }

    public Set<WordCard> getWords() {
        return words;
    }

    public Hint getCurrentHint() {
        return currentHint;
    }

    public Map<Team, Integer> getTeamToScore() {
        return teamToScore;
    }
}
