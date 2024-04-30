package engine;

import engine.gamestructure.GameStructureData;

public interface CodenamesEngine {
    // Accepts a filename argument, reads data according to the XML schema, loads attributes into the game engine.
    // Return true if the operation ended successfully, otherwise false.
    public boolean readFromDescriptorFile(String fileName);

    // GameInstanceData - a class containing details about a game instance
    // Returns an instance of the current game instance's details after being read from a valid XML file.
    // TODO Preventing execution if the file hasn't been loaded yet
    public GameStructureData getCurrentGameStructureDetails();
    public void beginGame();
    public boolean makeTurn();
    public void currentGameStatus();
    public void closeGame();

}

// fields
// private boolean hasDescriptorBeenLoaded

// GameInstanceData
// private HashMap<String> gameWords
// private HashMap<String> blackWords
// private int blackWordsCount
// private int cardsCount
// private int rowCount
// private int columnCount
// private int teamCount
// private String[] teamNames
// private int[] teamCardCount