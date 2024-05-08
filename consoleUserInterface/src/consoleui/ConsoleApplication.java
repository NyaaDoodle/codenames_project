package consoleui;

import engine.GameEngine;

public class ConsoleApplication implements CodenamesConsoleApplication {
    GameEngine engine = new GameEngine();
    public boolean firstTest() {
        engine.readFromXMLFile("hahahahahaha");
        GameStructureData testGID = engine.getCurrentGameStructureDetails();
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
