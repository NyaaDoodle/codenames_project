package engine.gameinstance;

import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameInstanceData {
    private final GameStructure gameStructure;
    private final GameWordCards wordCards;
    private final Map<Team, Integer> teamToScore;
    private final Hint currentHint;

    public GameInstanceData(GameInstance gameInstance) {
        this.gameStructure = gameInstance.getGameStructure();
        this.wordCards = gameInstance.getWordCards();
        this.teamToScore = gameInstance.getTeamToScore();
        this.currentHint = gameInstance.getCurrentHint();
    }

    public GameStructure getGameStructure() {
        return gameStructure;
    }

    public GameWordCards getWordCards() {
        return wordCards;
    }

    public Map<Team, Integer> getTeamToScore() {
        return teamToScore;
    }

    public Hint getCurrentHint() {
        return currentHint;
    }

    @Override
    public String toString() {
        return "GameInstanceData{" +
                "gameStructure=" + gameStructure +
                ", wordCards=" + wordCards +
                ", teamToScore=" + teamToScore +
                ", currentHint=" + (currentHint != null ? currentHint : "No hint has been set yet") +
                '}';
    }
}
