package engine.gamestructure;

import java.util.Objects;

public class Team {
    private final String name;
    private final int cardCount;

    public Team(String name, int cardCount) {
        this.name = name;
        this.cardCount = cardCount;
    }

    public String getName() {
        return name;
    }

    public int getCardCount() {
        return cardCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(getName(), team.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", cardCount=" + cardCount +
                '}';
    }
}
