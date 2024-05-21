package engine.gameinstance;

import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.*;

public class GameInstanceData {
    private final GameStructure gameStructure;
    private final GameWordCards wordCards;
    private final Map<Team, Integer> teamToScore;
    private final TurnOrder turnOrder;
    private final GameState gameState;
    private final ViewingState viewingState;
    private final Hint currentHint;

    public GameInstanceData(GameInstance gameInstance) {
        this.gameStructure = gameInstance.getGameStructure();
        this.wordCards = gameInstance.getWordCards();
        this.teamToScore = gameInstance.getTeamToScore();
        this.turnOrder = gameInstance.getTurnOrder();
        this.gameState = gameInstance.getGameState();
        this.viewingState = gameInstance.getViewingState();
        this.currentHint = gameInstance.getCurrentHint();
    }

    public GameStructure getGameStructure() {
        return gameStructure;
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

    public Hint getCurrentHint() {
        return currentHint;
    }

    public ViewingState getViewingState() {
        return viewingState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
