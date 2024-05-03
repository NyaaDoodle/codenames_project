package engine;

import engine.gameinstance.GameInstanceData;
import engine.gamestructure.GameStructureData;

public interface CodenamesEngine {
    public boolean readFromDescriptorFile(String fileName);
    public GameStructureData getCurrentGameStructureData();
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