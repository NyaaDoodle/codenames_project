package consoleui;

import engine.GameEngine;
import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.gamestructure.Words;

import java.util.List;
import java.util.Set;

public class ConsoleApplication implements CodenamesConsoleApplication {
    public static void main(String[] args) {
        xmlLoadTest("gameEngine/test-files/error-2.xml");
        printCurrentGameStructure(engine.getCurrentGameStructure());
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
        final List<Team> teams = gameStructure.getTeams();
        for (Team team : teams) {
            System.out.println(team.getName() + ", " + team.getStartingCardCount());
        }
    }
}
