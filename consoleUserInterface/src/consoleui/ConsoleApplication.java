package consoleui;

import engine.GameEngine;
import engine.gameinstance.GameInstanceData;

public class ConsoleApplication implements CodenamesConsoleApplication {
    GameEngine engine = new GameEngine();
    public boolean firstTest() {
        engine.readFromDescriptorFile("hahahahahaha");
        GameInstanceData testGID = engine.getCurrentGameInstanceDetails();
        System.out.println(testGID.getWords().getGameWords());
        System.out.println(testGID.getWords().getBlackWords());
        System.out.println(testGID.getBoard().getCardCount());
        System.out.println(testGID.getBoard().getBlackCardCount());
        System.out.println(testGID.getBoard().getRows());
        System.out.println(testGID.getBoard().getColumns());
        System.out.println(testGID.getTeams().get(0).getName());
        System.out.println(testGID.getTeams().get(1).getName());
        return true;
    }
}
