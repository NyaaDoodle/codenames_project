package engine.gameinstance;

import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.*;

public class GameInstanceData {
    private final GameStructure gameStructure;
    private final GameWordCards wordCards;
    private final Map<Team, Integer> teamToScore;
    private final TurnOrder turnOrder;
    private final Hint currentHint;
    private final boolean hasGameEnded;
    private final Team teamWon;

    public GameInstanceData(GameInstance gameInstance) {
        this.gameStructure = gameInstance.getGameStructure();
        this.wordCards = gameInstance.getWordCards();
        this.teamToScore = gameInstance.getTeamToScore();
        this.turnOrder = gameInstance.getTurnOrder();
        this.currentHint = gameInstance.getCurrentHint();
        this.hasGameEnded = gameInstance.hasGameEnded();
        this.teamWon = gameInstance.getTeamWon();
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

    public boolean hasGameEnded() {
        return hasGameEnded;
    }

    public Team getCurrentTurn() {
        return turnOrder.getCurrentTurn();
    }

    public Team getNextTurn() {
        return turnOrder.getNextTurn();
    }

    public Team getTeamWon() {
        return teamWon;
    }
}
