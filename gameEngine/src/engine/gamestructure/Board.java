package engine.gamestructure;

public class Board {
    private int cardCount;
    private int blackCardCount;
    private int rows;
    private int columns;

    public Board(int cardCount, int blackCardCount, int rows, int columns) {
        this.cardCount = cardCount;
        this.blackCardCount = blackCardCount;
        this.rows = rows;
        this.columns = columns;
    }

    public Board(Board copyBoard) {
        this.cardCount = copyBoard.cardCount;
        this.blackCardCount = copyBoard.blackCardCount;
        this.rows = copyBoard.rows;
        this.columns = copyBoard.columns;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    public int getBlackCardCount() {
        return blackCardCount;
    }

    public void setBlackCardCount(int blackCardCount) {
        this.blackCardCount = blackCardCount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
