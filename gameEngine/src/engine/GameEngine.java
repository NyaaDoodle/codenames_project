package engine;

import engine.gameinstance.GameInstance;
import engine.gameinstance.GameInstanceData;
import engine.gamestructure.GameStructure;
import engine.jaxb.generated.JAXBConversion;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameEngine implements CodenamesEngine {
    GameStructure gameStructure;
    GameInstance gameInstance;
    public GameEngine() {}

    @Override
    public void readFromGameStructureFile(String fileName) throws Exception {
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
        gameInstance = new GameInstance(gameStructure);
        
    }

    @Override
    public void changeViewingState() {

    }

    @Override
    public void makeMove(int wordIndex) {

    }

    @Override
    public GameInstanceData getCurrentGameInstanceData() { return new GameInstanceData(gameInstance); }

    @Override
    public void endGame() {

    }

    @Override
    public void closeProgram() {

    }
}
