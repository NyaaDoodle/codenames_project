package engine.gameinstance;

import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameInstance {
    private final GameStructure gameStructure;
    private List<WordCard> words;
    private Hint currentHint;
    private Map<Team, Integer> teamToScore;
    public GameInstance(GameStructure gameStructure) {
        this.gameStructure = gameStructure;
        // ..................
    }

    public GameStructure getGameStructure() {
        return gameStructure;
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
