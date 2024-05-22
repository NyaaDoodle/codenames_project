package engine;

import engine.gameinstance.GameInstance;
import engine.gameinstance.GameInstanceData;
import engine.gameinstance.Hint;
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
    public void readFromGameStructureFile(final String fileName) throws Exception {
        try (InputStream inputStream = Files.newInputStream(Paths.get(fileName));) {
            gameStructure = JAXBConversion.XMLToObjectsConversion(inputStream);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (JAXBException je) {
            je.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();

        }
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
    public void makeMove(final int wordIndex) {

    }

    @Override
    public GameInstanceData getCurrentGameInstanceData() { return new GameInstanceData(gameInstance); }

    @Override
    public void endGame() {

    }
}
