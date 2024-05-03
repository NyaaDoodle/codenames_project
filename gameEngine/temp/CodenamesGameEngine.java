public interface CodenamesGameEngine {
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
