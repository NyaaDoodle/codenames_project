package engine;

import engine.gameinstance.GameInstanceData;
import engine.gameinstance.Hint;
import engine.gamestructure.GameStructure;

public interface CodenamesEngine {
    public void readFromGameStructureFile(final String fileName) throws Exception;
    public GameStructure getCurrentGameStructure();
    public void beginGame();
    public void beginTurn();
    public void setCurrentHint(final Hint newHint);
    public void makeMove(final int wordIndex);
    public GameInstanceData getCurrentGameInstanceData();
    public void endGame();
}