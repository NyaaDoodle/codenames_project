package engine;

import engine.exceptions.GameStructureFileException;
import engine.gameinstance.GameInstance;
import engine.gameinstance.GameInstanceData;
import engine.gameinstance.Hint;
import engine.gameinstance.MoveEvent;
import engine.gamestructure.GameStructure;
import engine.jaxb.generated.JAXBConversion;

import javax.xml.bind.JAXBException;
import java.io.InputStream;
import java.util.LinkedList;

public class GameEngine implements CodenamesEngine {
    GameStructure gameStructure;
    GameInstance gameInstance;
    public GameEngine() {}

    @Override
    public void readFromGameStructureFile(final InputStream inputStream) throws JAXBException, GameStructureFileException {
        if (gameInstance != null) {
            gameInstance = null;
        }
        gameStructure = JAXBConversion.XMLToObjectsConversion(inputStream);
    }

    @Override
    public GameStructure getCurrentGameStructure() {
        return gameStructure;
    }

    @Override
    public void beginGame() {
        gameInstance = new GameInstance(gameStructure, new LinkedList<>(gameStructure.getTeams()));
    }

    @Override
    public void beginTurn() {
        gameInstance.moveToNextTurn();
    }

    @Override
    public void setCurrentHint(final Hint newHint) {
        gameInstance.setCurrentHint(newHint);
    }

    @Override
    public MoveEvent makeMove(final int wordIndex) {
        return gameInstance.makeMove(wordIndex);
    }

    @Override
    public GameInstanceData getCurrentGameInstanceData() { return new GameInstanceData(gameInstance); }

    @Override
    public void clearGameInstance() {
        if (gameInstance.hasGameEnded()) {
            gameInstance = null;
        }
    }
    @Override
    public void endGameAbruptly() {
        gameInstance.endGameAbruptly();
    }
}
