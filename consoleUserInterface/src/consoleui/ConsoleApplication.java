package consoleui;

import engine.GameEngine;
import engine.gameinstance.*;
import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.gamestructure.Words;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                    beginGameInstance();
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
    private static void gameloop() {
        GameInstanceData gameInstanceData = engine.getCurrentGameInstanceData();
        while (gameInstanceData.getGameState() != GameState.Ended) {
            printBoardState(gameInstanceData.getViewingState());
            gameInstanceData = engine.getCurrentGameInstanceData();
        }
    }
    private static void printBoardState(final ViewingState viewingState) {
        final Board board = engine.getCurrentGameStructure().getBoard();
        final int boardRows = board.getRows();
        final int boardColumns = board.getColumns();
        /*
     encapsulation
[1] X (My team and such)
required space: 2 spaces between each word
for each word:
check if the word or the tag is longer. if equal, end. check the difference of the lengths, and move the shorter string (difference / 2) spaces forward.
then, add 2 spaces after the end of the longer string, and begin anew in that position on both output strings
         */

    }
    private static String createWordCardTag(final WordCard wordCard, final int index, final ViewingState viewingState) {
        Set<Team> teams = engine.getCurrentGameStructure().getTeams();
        String wordCardTag = "[" + index + "]";
        if (viewingState == ViewingState.OpenView || wordCard.isFound()) {
            if (viewingState == ViewingState.HiddenView) {
                wordCardTag += " V";
            }
            else {
                wordCardTag += " " + (wordCard.isFound() ? "V" : "X");
            }
            if (teams.contains(wordCard.getTeam())) {
                wordCardTag += " (" + wordCard.getTeam().getName() + ")";
            }
            else if (wordCard.isBlackWord()){
                wordCardTag += " (BLACK)";
            }
        }
        return wordCardTag;
    }
    private static void beginGameInstance() {
        System.out.println("Beginning new game...");
        gameloop();
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
        List<Integer> allowedInputsWhenNotLoaded = IntStream.rangeClosed(1, 2).boxed().collect(Collectors.toList());
        List<Integer> allowedInputsWhenLoaded = IntStream.rangeClosed(1, 4).boxed().collect(Collectors.toList());
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
    private static boolean hasGameInstanceEnded() {
        return engine.getCurrentGameInstanceData().getGameState() == GameState.Ended;
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
        System.out.println();
    }
    public static void printCurrentGameInstance() {
        final GameInstanceData gameInstanceData = engine.getCurrentGameInstanceData();
        if (gameInstanceData == null) {
            System.out.println("Game instance has not started yet.");
            return;
        }
        System.out.println(gameInstanceData);
    }
}
