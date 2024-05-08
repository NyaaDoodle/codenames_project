package engine;

import engine.gameinstance.GameInstanceData;
import engine.gamestructure.GameStructure;

public class GameEngine implements CodenamesEngine {
    GameStructure gameStructure;

    public GameEngine() {}

    @Override
    public boolean readFromGameStructureFile(String fileName) {
        
        return false;
    }

    @Override
    public GameStructure getCurrentGameStructure() {
        return gameStructure;
    }

    @Override
    public void beginGame() {

    }

    @Override
    public void changeViewingState() {

    }

    @Override
    public void makeMove(int wordIndex) {

    }

    @Override
    public GameInstanceData getCurrentGameInstanceData() {
        return null;
    }

    @Override
    public void endGame() {

    }

    @Override
    public void closeProgram() {

    }
}
