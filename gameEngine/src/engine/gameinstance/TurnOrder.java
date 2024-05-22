package engine.gameinstance;

import engine.gamestructure.Team;

import java.util.*;

public class TurnOrder {
    private final Queue<Team> queue;
    private Team currentTurn = null;
    private Map<Team, Integer> teamToTurnCount = new HashMap<>();

    public TurnOrder(Queue<Team> turnOrder) {
        this.queue = turnOrder;
        turnOrder.forEach(team -> teamToTurnCount.put(team, 0));
    }
    public Team moveToNextTurn() {
        currentTurn = queue.remove();
        queue.add(currentTurn);
        teamToTurnCount.put(currentTurn, teamToTurnCount.get(currentTurn) + 1);
        return currentTurn;
    }
    public Queue<Team> getQueue() {
        return new LinkedList<>(queue);
    }
    public Team getCurrentTurn() {
        return currentTurn;
    }
    public Team getNextTurn() {
        return queue.element();
    }
    public Map<Team, Integer> getTeamToTurnCount() {
        return Collections.unmodifiableMap(teamToTurnCount);
    }
}
