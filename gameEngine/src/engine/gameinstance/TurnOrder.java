package engine.gameinstance;

import engine.gamestructure.Team;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class TurnOrder {
    private final Queue<Team> queue;
    private Team currentTurn = null;

    public TurnOrder(Queue<Team> turnOrder) {
        this.queue = turnOrder;
    }
    public Team moveToNextTurn() {
        currentTurn = queue.remove();
        queue.add(currentTurn);
        return currentTurn;
    }
    public Queue<Team> getQueue() {
        return new LinkedList<>(queue);
    }
    public Team getCurrentTurn() {
        return currentTurn;
    }
}
