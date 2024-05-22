package engine;

import engine.gameinstance.GameInstance;
import engine.gameinstance.GameInstanceData;
import engine.gameinstance.Hint;
import engine.gameinstance.MoveEvent;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.jaxb.generated.JAXBConversion;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

public class GameEngine implements CodenamesEngine {
    GameStructure gameStructure;
    GameInstance gameInstance;
    public GameEngine() {}

    @Override
    public void readFromGameStructureFile(final InputStream fileInputStream) throws JAXBException {
        gameStructure = JAXBConversion.XMLToObjectsConversion(fileInputStream);
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
    public void endGame() {
        if (gameInstance.hasGameEnded()) {
            gameInstance = null;
        }
    }
}
