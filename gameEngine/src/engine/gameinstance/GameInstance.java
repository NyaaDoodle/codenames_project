package engine.gameinstance;

import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.*;

public class GameInstance {
    private final static int STARTING_TEAM_SCORE = 0;
    private final GameStructure gameStructure;
    private final GameWordCards wordCards;
    private Map<Team, Integer> teamToScore = new HashMap<>();
    private Hint currentHint;
    public GameInstance(GameStructure gameStructure) {
        this.gameStructure = gameStructure;
        this.wordCards = new GameWordCards(gameStructure);
        gameStructure.getTeams().stream().forEach((team) -> teamToScore.put(team, STARTING_TEAM_SCORE));
        this.currentHint = null;
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

    public GameWordCards getWordCards() {
        return wordCards;
    }

    public Map<Team, Integer> getTeamToScore() {
        return Collections.unmodifiableMap(teamToScore);
    }
}
