package consoleui;

import engine.GameEngine;
import engine.gameinstance.GameInstance;
import engine.gameinstance.GameInstanceData;
import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.gamestructure.Words;

import java.util.List;
import java.util.Set;

public class ConsoleApplication {
    private static GameEngine engine = new GameEngine();
    private static int currentMenuIndex = 1;
    private static boolean toExitProgram = false;
    public static void main(String[] args) {
        while (!(toExitProgram)) {
            presentMainMenu();
        }
    }
    private static void acceptUserInput() {}
    private static void presentMainMenu() {
        printMainMenu();
    }
    private static void printMainMenu() {
        currentMenuIndex = 1;
        System.out.println("Codenames, Version 1");
        System.out.println("Choose a number to select an option:");
        if (!(isGameStructureLoaded())) {
            System.out.println(currentIndexString() + "Load game format");
            System.out.println(currentIndexString() + "Exit program");
        }
        else {
            System.out.println(currentIndexString() + "Start a new game");
            System.out.println(currentIndexString() + "Show loaded game format information");
            System.out.println(currentIndexString() + "Load a different game format");
            System.out.println(currentIndexString() + "Exit program");
        }
    }
    private static String currentIndexString() {
        return "(" + currentMenuIndex++ + ") ";
    }
    private static boolean isGameStructureLoaded() {
        return engine.getCurrentGameStructure() != null;
    }
    public static void testingMain() {
        xmlLoadTest("gameEngine/test-files/classic.xml");
        printCurrentGameStructure(engine.getCurrentGameStructure());
        engine.beginGame();
        System.out.println(engine.getCurrentGameInstanceData().getWordCards().getWordCardList());
    }
    public static void xmlLoadTest(String fileName) {
        try {
            engine.readFromGameStructureFile(fileName);
        }
        catch (Exception e) {
            System.out.println("aaaaaaaaaaaa");
        }
    }
    public static void printCurrentGameStructure(GameStructure gameStructure) {
        if (gameStructure == null) { return; }
        final Words words = gameStructure.getWords();
        System.out.println(words.getGameWords());
        System.out.println(words.getBlackWords());
        final Board board = gameStructure.getBoard();
        System.out.println(board.getCardCount());
        System.out.println(board.getBlackCardCount());
        System.out.println(board.getRows());
        System.out.println(board.getColumns());
        final Set<Team> teams = gameStructure.getTeams();
        for (Team team : teams) {
            System.out.println(team.getName() + ", " + team.getCardCount());
        }
    }
    public static void printCurrentGameInstance(GameInstanceData gameInstanceData) {
        if (gameInstanceData == null) { return; }
        System.out.println(gameInstanceData);
    }
}
