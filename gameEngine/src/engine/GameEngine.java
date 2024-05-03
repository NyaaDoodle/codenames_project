package engine;

import engine.gameinstance.GameInstanceData;
import engine.gamestructure.GameStructureData;

public class GameEngine implements CodenamesEngine {
    @Override
    public boolean readFromDescriptorFile(String fileName) {
        return false;
    }

    @Override
    public GameStructureData getCurrentGameStructureData() {
        return null;
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
