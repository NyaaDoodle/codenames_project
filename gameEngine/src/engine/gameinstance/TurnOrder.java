package engine.gameinstance;

import engine.gamestructure.Team;

import java.util.Queue;

public class TurnOrder {
    private final Queue<Team> queue;

    public TurnOrder(Queue<Team> turnOrder) {
        this.queue = turnOrder;
    }
    public Team popNextTurn() {
        Team outTeam = queue.remove();
        queue.add(outTeam);
        return outTeam;
    }
}
