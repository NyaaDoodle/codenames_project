package engine.gameinstance;

import engine.GameEngine;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.*;

public class GameInstance {
    private final static int STARTING_TEAM_SCORE = 0;
    private final GameStructure gameStructure;
    private final GameWordCards wordCards;
    private final Map<Team, Integer> teamToScore = new HashMap<>();
    private final TurnOrder turnOrder;
    private GameState gameState = GameState.Standby;
    private ViewingState viewingState = ViewingState.HiddenView;
    private Hint currentHint;

    public GameInstance(final GameStructure gameStructure, final Queue<Team> turnOrder) {
        this.gameStructure = gameStructure;
        this.wordCards = new GameWordCards(gameStructure);
        gameStructure.getTeams().stream().forEach((team) -> teamToScore.put(team, STARTING_TEAM_SCORE));
        this.currentHint = null;
        this.turnOrder = new TurnOrder(turnOrder);
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

    public TurnOrder getTurnOrder() {
        return turnOrder;
    }

    public GameState getGameState() {
        return gameState;
    }

    public ViewingState getViewingState() {
        return viewingState;
    }

    public void setViewingState(ViewingState viewingState) {
        this.viewingState = viewingState;
    }
}
