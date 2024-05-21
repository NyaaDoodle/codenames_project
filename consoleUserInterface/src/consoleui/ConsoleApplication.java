package consoleui;

import engine.GameEngine;
import engine.gameinstance.GameInstance;
import engine.gameinstance.GameInstanceData;
import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.gamestructure.Words;

import java.util.*;

public class ConsoleApplication {
    private static GameEngine engine = new GameEngine();
    private static int currentMenuIndex = 1;
    private static boolean toExitProgram = false;
    public static void main(String[] args) {
        int currentUserInput;
        while (!(toExitProgram)) {
            currentUserInput = presentMainMenu();
            selectActionMainMenu(currentUserInput);
        }
    }
    private static void selectActionMainMenu(final int input) {
        switch (input) {
            case 1:
                if (!(isGameStructureLoaded())) {
                    loadGameStructure();
                }
                else {
                    // Begin game
                }
                break;
            case 2:
                if (!(isGameStructureLoaded())) {
                    toExitProgram = true;
                }
                else {
                    printCurrentGameStructure();
                }
                break;
            case 3:
                if (isGameStructureLoaded()) {
                    loadGameStructure();
                }
                break;
            case 4:
                if (isGameStructureLoaded()) {
                    toExitProgram = true;
                }
                break;
            default:
                break;
        }
    }
    private static void loadGameStructure() {
        Scanner scanner = new Scanner(System.in);
        Collection<String> allowedFileFormats = new HashSet<>(Arrays.asList(".xml"));
        System.out.println("Write the full path of the game format file: (Supported file types: " + allowedFileFormats + ") ");
        String userInput = scanner.nextLine();
        try {
            engine.readFromGameStructureFile(userInput);
        } catch (Exception e) {
            // Placeholder, currently assuming "happy path"
            System.exit(-1);
        }
    }
    private static int acceptIntInputFromUser(final List<Integer> acceptedInts, final String unexpectedInputMessage) {
        final int DEFAULT_VALUE = -1;
        Scanner scanner = new Scanner(System.in);
        int userInputInt = DEFAULT_VALUE;
        boolean isValidInputAccepted = false;
        while (!(isValidInputAccepted)) {
            userInputInt = scanner.nextInt();
            if (acceptedInts.contains(userInputInt)) {
                isValidInputAccepted = true;
            }
            else {
                System.out.println(unexpectedInputMessage + " " + acceptedInts);
            }
        }
        return userInputInt;
    }
    private static int presentMainMenu() {
        List<Integer> allowedInputsWhenNotLoaded = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> allowedInputsWhenLoaded = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        printMainMenu();
        return acceptIntInputFromUser(!(isGameStructureLoaded()) ? allowedInputsWhenNotLoaded : allowedInputsWhenLoaded, "Invalid key, please enter one of the following numbers to select your option:");
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
    public static void printCurrentGameStructure() {
        final GameStructure gameStructure = engine.getCurrentGameStructure();
        if (gameStructure == null) {
            System.out.println("Game structure has not been loaded yet.");
            return;
        }
        final Words words = gameStructure.getWords();
        final Board board = gameStructure.getBoard();
        final Set<Team> teams = gameStructure.getTeams();
        System.out.println("Amount of possible game words in word bank: " + words.getGameWords().size());
        System.out.println("Amount of possible black words in word bank: " + words.getBlackWords().size());
        System.out.println("Amount of regular words in a game: " + board.getCardCount());
        System.out.println("Amount of black words in a game: " + board.getBlackCardCount());
        System.out.println("Playing teams:");
        teams.stream().forEach((team) -> {
            System.out.println("Team " + team.getName() + ", card amount: " + team.getCardCount());
        });
        System.out.println("");
    }
    public static void printCurrentGameInstance() {
        GameInstanceData gameInstanceData = engine.getCurrentGameInstanceData();
        if (gameInstanceData == null) {
            System.out.println("Game instance has not started yet.");
            return;
        }
        System.out.println(gameInstanceData);
    }
}
