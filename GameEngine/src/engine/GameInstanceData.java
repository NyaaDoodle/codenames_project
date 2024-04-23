package engine;

import java.util.List;

public class GameInstanceData {
    private List<String> gameWords;
    private List<String> blackWords;
    private int blackWordsCount;
    private int cardsCount;
    private int rowCount;
    private int columnCount;
    private int teamCount;
    private String[] teamNames;
    private int[] teamCardCount;

    public GameInstanceData() {}

    public List<String> getGameWords() {
        return gameWords;
    }

    public void setGameWords(List<String> gameWords) {
        this.gameWords = gameWords;
    }

    public List<String> getBlackWords() {
        return blackWords;
    }

    public void setBlackWords(List<String> blackWords) {
        this.blackWords = blackWords;
    }

    public int getBlackWordsCount() {
        return blackWordsCount;
    }

    public void setBlackWordsCount(int blackWordsCount) {
        this.blackWordsCount = blackWordsCount;
    }

    public int getCardsCount() {
        return cardsCount;
    }

    public void setCardsCount(int cardsCount) {
        this.cardsCount = cardsCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public String[] getTeamNames() {
        return teamNames;
    }

    public void setTeamNames(String[] teamNames) {
        this.teamNames = teamNames;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }

    public int[] getTeamCardCount() {
        return teamCardCount;
    }

    public void setTeamCardCount(int[] teamCardCount) {
        this.teamCardCount = teamCardCount;
    }
}
