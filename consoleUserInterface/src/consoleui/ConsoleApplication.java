package consoleui;

import engine.GameEngine;
import engine.gameinstance.GameInstanceData;

public class ConsoleApplication implements CodenamesConsoleApplication {
    GameEngine engine = new GameEngine();
    public boolean firstTest() {
        GameInstanceData testGID = engine.getCurrentGameInstanceDetails();
        System.out.println(testGID.getWords().getGameWords());
        return true;
    }
}
