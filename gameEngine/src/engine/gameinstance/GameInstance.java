package engine.gameinstance;

import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.*;

public class GameInstance {
    private final static int STARTING_TEAM_SCORE = 0;
    private final GameStructure gameStructure;
    private final GameWordCards wordCards;
    private final Map<Team, Integer> teamToScore = new HashMap<>();
    private final TurnOrder turnOrder;
    private Hint currentHint;
    private boolean hasGameEnded = false;
    private Team teamWon;

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

    public void setCurrentHint(final Hint hint) {
        this.currentHint = hint;
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

    public boolean hasGameEnded() {
        return hasGameEnded;
    }

    public void moveToNextTurn() {
        turnOrder.moveToNextTurn();
    }

    public MoveEvent makeMove(final int wordIndex) {
        MoveEvent moveEvent;
        WordCard selectedWord = getWordCards().getWordCardList().get(wordIndex);
        Team cardTeam = selectedWord.getTeam();
        selectedWord.setFound(true);
        if (gameStructure.getTeams().contains(cardTeam)) {
            teamToScore.put(cardTeam, teamToScore.get(cardTeam) + 1);
            moveEvent = cardTeam.equals(turnOrder.getCurrentTurn()) ? MoveEvent.CardBelongingToCurrentTeam : MoveEvent.CardBelongingToOtherTeam;
            if (teamToScore.get(cardTeam).equals(cardTeam.getCardCount())) {
                hasGameEnded = true;
                teamWon = cardTeam;
            }
        }
        else if (selectedWord.isBlackWord()) {
            hasGameEnded = true;
            teamWon = turnOrder.getNextTurn(); // only applicable for 2 teams
            moveEvent = MoveEvent.BlackWord;
        }
        else {
            moveEvent = MoveEvent.NeutralWord;
        }
        return moveEvent;
    }
    public Team getTeamWon() {
        if (hasGameEnded) {
            return teamWon;
        }
        return null;
    }
}
