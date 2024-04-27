package engine;

public class GameEngine implements CodenamesEngine {
    private GameInstanceData currentGameData = null;

    @Override
    public boolean readFromDescriptorFile(String fileName) {
        return false;
    }

    @Override
    public GameInstanceData getCurrentGameInstanceDetails() {
        return new GameInstanceData(currentGameData);
    }

    @Override
    public void beginGame() {

    }

    @Override
    public boolean makeTurn() {
        return false;
    }

    @Override
    public void currentGameStatus() {

    }

    @Override
    public void closeGame() {

    }
}
