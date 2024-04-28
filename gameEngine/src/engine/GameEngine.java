package engine;

import engine.gameinstance.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameEngine implements CodenamesEngine {
    private GameInstance currentGameData = new GameInstance();

    public GameEngine() {
        Words testWords = new Words(Arrays.asList("one", "two"), Arrays.asList("aaaa"));
        Board testBoard = new Board(1, 2, 3, 4);
        List<Team> testTeams= new ArrayList<>(Arrays.asList(new Team("a", 1, 1), new Team("b", 1, 0)));
        currentGameData.setWords(testWords);
        currentGameData.setBoard(testBoard);
        currentGameData.setTeams(testTeams);
    }

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
