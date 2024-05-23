package engine;

import engine.exceptions.GameStructureFileException;
import engine.gameinstance.GameInstanceData;
import engine.gameinstance.Hint;
import engine.gameinstance.MoveEvent;
import engine.gamestructure.GameStructure;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

public interface CodenamesEngine {
    void readFromGameStructureFile(final InputStream inputStream) throws JAXBException, GameStructureFileException;
    GameStructure getCurrentGameStructure();
    void beginGame();
    void beginTurn();
    void setCurrentHint(final Hint newHint);
    MoveEvent makeMove(final int wordIndex);
    GameInstanceData getCurrentGameInstanceData();
    void endGameAbruptly();
    void clearGameInstance();
}