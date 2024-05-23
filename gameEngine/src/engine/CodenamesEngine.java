package engine;

import engine.exceptions.GameStructureFileException;
import engine.gameinstance.GameInstanceData;
import engine.gameinstance.Hint;
import engine.gameinstance.MoveEvent;
import engine.gamestructure.GameStructure;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;

public interface CodenamesEngine {
    public void readFromGameStructureFile(final InputStream inputStream) throws JAXBException, GameStructureFileException;
    public GameStructure getCurrentGameStructure();
    public void beginGame();
    public void beginTurn();
    public void setCurrentHint(final Hint newHint);
    public MoveEvent makeMove(final int wordIndex);
    public GameInstanceData getCurrentGameInstanceData();
    public void endGame();
}