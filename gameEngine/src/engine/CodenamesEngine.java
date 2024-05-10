package engine;

import engine.gameinstance.GameInstanceData;
import engine.gamestructure.GameStructure;

public interface CodenamesEngine {
    public void readFromGameStructureFile(String fileName) throws Exception;
    public GameStructure getCurrentGameStructure();
    public void beginGame();
    public void changeViewingState();
    public void makeMove(int wordIndex);
    public GameInstanceData getCurrentGameInstanceData();
    public void endGame();
    public void closeProgram();
    // Bonuses:
    // public boolean saveGameInstanceState();
    // public boolean loadGameInstanceState();
}