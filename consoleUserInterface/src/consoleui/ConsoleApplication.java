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
    private static final GameEngine engine = new GameEngine();
    private static GameStructure gameStructure;
    private static GameInstanceData instanceData;
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
    private static void beginTurn() {
        final int STOP_INT = -1;
        engine.beginTurn();
        updateCurrentGameInstanceData();
        Team currentTurnTeam = instanceData.getCurrentTurn();
        System.out.print("It is Team " + currentTurnTeam.getName() + "'s turn");
        System.out.println(", current score: (" + instanceData.getTeamToScore().get(currentTurnTeam) + "/" + currentTurnTeam.getCardCount() +")");
        System.out.println("Team " + currentTurnTeam.getName() + " Definer(s):");
        printBoardState(ViewingState.OpenView);
        engine.setCurrentHint(acceptNewHintFromUser());
        updateCurrentGameInstanceData();
        System.out.println();
        System.out.println("Team " + currentTurnTeam.getName() + " Guesser(s): ");
        boolean stopGuessingEarlier = false;
        boolean gameEnded = false;
        printBoardState(ViewingState.HiddenView);
        Hint currentHint = instanceData.getCurrentHint();
        System.out.println("Hint: " + currentHint.getHintWords() + ", number: " + currentHint.getNumber());
        for (int i = 0; i < currentHint.getNumber() && !stopGuessingEarlier && !gameEnded; i++) {
            System.out.println("Enter a number corresponding to a word to select that word: (write \"end\" to prematurely end the turn)");
            int guessInput = acceptIntInputFromUser(IntStream.rangeClosed(1, gameStructure.getTotalCardsInGame()).boxed().collect(Collectors.toList()), "end");
            if (guessInput != STOP_INT) {
                engine.makeMove(guessInput);
                updateCurrentGameInstanceData();
            }
            else {
                stopGuessingEarlier = true;
            }
        }
    }
    private static void selectActionStandbyMenu(final int input) {
        switch (input) {
            case 1:
                beginTurn();
                break;
            case 2:
                printCurrentGameInstance();
                break;
            case 3:
                beginGameInstance();
                break;
            case 4:
                loadGameStructure();
                break;
            case 5:
                toExitProgram = true;
                break;
        }
    }
    private static void gameLoop() {
        while (!instanceData.hasGameEnded()) {
            printStandbyMenu();
            int userInput = acceptIntInputFromUser(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));
            selectActionStandbyMenu(userInput);
        }
    }
    private static void updateCurrentGameStructure() {
        gameStructure = engine.getCurrentGameStructure();
    }
    private static void updateCurrentGameInstanceData() {
        instanceData = engine.getCurrentGameInstanceData();
    }
    private static void printStandbyMenu() {
        printBoardState(ViewingState.HiddenView);
        System.out.println("Next turn: Team " + instanceData.getTurnOrder().getNextTurn().getName());
        System.out.println("(1) Begin turn");
        System.out.println("(2) Show current game information");
        System.out.println("(3) Recreate new game");
        System.out.println("(4) Load new game format");
        System.out.println("(5) Exit program");
    }
    private static void printBoardState(final ViewingState viewingState) {
        final Board board = gameStructure.getBoard();
        final int boardRows = board.getRows();
        final int boardColumns = board.getColumns();
        final int totalCards = board.getCardCount() + board.getBlackCardCount();
        final List<WordCard> wordCards = engine.getCurrentGameInstanceData().getWordCards().getWordCardList();
        for (int i = 0; (i < boardRows) && (i*boardColumns < totalCards); i++) {
            List<WordCard> currentLineList = wordCards.stream().skip((long)i*boardColumns).limit(boardColumns).collect(Collectors.toList());
            currentLineList.forEach(wordCard -> System.out.print(wordCard.getWord() + "  "));
            System.out.println();
            currentLineList.forEach(wordCard -> System.out.print(createWordCardTag(wordCard, viewingState) + "  "));
            System.out.println();
        }
        /*
     encapsulation
[1] X (My team and such)
required space: 2 spaces between each word
for each word:
check if the word or the tag is longer. if equal, end. check the difference of the lengths, and move the shorter string (difference / 2) spaces forward.
then, add 2 spaces after the end of the longer string, and begin anew in that position on both output strings
         */

    }
    private static String createWordCardTag(final WordCard wordCard, final ViewingState viewingState) {
        Set<Team> teams = engine.getCurrentGameStructure().getTeams();
        String wordCardTag = "[" + (wordCard.getIndex() + 1) + "]";
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
        engine.beginGame();
        updateCurrentGameInstanceData();
        gameLoop();
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
        updateCurrentGameStructure();
    }
    private static Hint acceptNewHintFromUser() {
        final int DEFAULT_VALUE = -1;
        Scanner scanner = new Scanner(System.in);
        String userInputHintWords;
        int userInputNumber = DEFAULT_VALUE;
        boolean isValidNumberAccepted = false;
        System.out.println("Enter the hint words (the number will be asked later):");
        userInputHintWords = scanner.nextLine();
        System.out.println("Now enter the number of words to guess:");
        while (!isValidNumberAccepted) {
            try {
                userInputNumber = scanner.nextInt();
                isValidNumberAccepted = true;
            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid input: not a number, please enter a number.");
            }
        }
        return new Hint(userInputHintWords, userInputNumber);
    }
    private static int acceptIntInputFromUser(final List<Integer> acceptedIntegers) {
        final int DEFAULT_VALUE = -1;
        Scanner scanner = new Scanner(System.in);
        int userInputInt = DEFAULT_VALUE;
        boolean isValidInputAccepted = false;
        while (!(isValidInputAccepted)) {
            try {
                userInputInt = scanner.nextInt();
                if (acceptedIntegers.contains(userInputInt)) {
                    isValidInputAccepted = true;
                } else {
                    System.out.println("Invalid key, please enter one of the following numbers to select your option: " + acceptedInts);
                }
            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid input: not a number, please enter a number");
            }
        }
        return userInputInt;
    }
    private static int acceptIntInputFromUser(final List<Integer> acceptedIntegers, final String terminatingString) {
        final int DEFAULT_VALUE = -1;
        Scanner scanner = new Scanner(System.in);
        int userInputInt = DEFAULT_VALUE;
        String rawUserInput;
        boolean isValidInputAccepted = false;
        while (!(isValidInputAccepted)) {
            rawUserInput = scanner.nextLine();
            if (rawUserInput.toLowerCase().equals(terminatingString)) {
                return DEFAULT_VALUE;
            } else {
                try {
                    userInputInt = Integer.parseInt(rawUserInput);
                    if (acceptedIntegers.contains(userInputInt)) {
                        isValidInputAccepted = true;
                    } else {
                        System.out.println("Invalid number, please enter one of the following numbers to select your option: " + acceptedIntegers);
                    }
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Invalid input: not a number, please enter a number or \"" + terminatingString + "\"to stop.");
                }
            }
        }
        return userInputInt;
    }
    private static int presentMainMenu() {
        List<Integer> allowedInputsWhenNotLoaded = IntStream.rangeClosed(1, 2).boxed().collect(Collectors.toList());
        List<Integer> allowedInputsWhenLoaded = IntStream.rangeClosed(1, 4).boxed().collect(Collectors.toList());
        printMainMenu();
        return acceptIntInputFromUser(!(isGameStructureLoaded()) ? allowedInputsWhenNotLoaded : allowedInputsWhenLoaded);
    }
    private static void printMainMenu() {
        System.out.println("Codenames, Version 1");
        System.out.println("Choose a number to select an option:");
        if (!(isGameStructureLoaded())) {
            System.out.println("(1) Load game format");
            System.out.println("(2) Exit program");
        }
        else {
            System.out.println("(1) Start a new game");
            System.out.println("(2) Show loaded game format information");
            System.out.println("(3) Load a different game format");
            System.out.println("(4) Exit program");
        }
    }
    private static boolean isGameStructureLoaded() {
        return gameStructure != null;
    }
    private static boolean hasGameInstanceEnded() {
        return instanceData.hasGameEnded();
    }
    private static void printCurrentGameStructure() {
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
        teams.forEach(team -> {
            System.out.println("Team " + team.getName() + ", card amount: " + team.getCardCount());
        });
        System.out.println();
    }
    private static void printCurrentGameInstance() {
        if (instanceData == null) {
            System.out.println("Game instance has not started yet.");
            return;
        }
        Map<Team, Integer> teamToScore = instanceData.getTeamToScore();
        Map<Team, Integer> teamToTurnCount = instanceData.getTurnOrder().getTeamToTurnCount();
        printBoardState(ViewingState.OpenView);
        for (Team team : gameStructure.getTeams()) {
            System.out.println("Team " + team.getName());
            System.out.println("Score: (" + teamToScore.get(team) + "/" + team.getCardCount() + ")");
            System.out.println("Turn count: " + teamToTurnCount.get(team));
        }
        System.out.println("Next turn: Team " + instanceData.getTurnOrder().getNextTurn().getName());
        System.out.println();
    }
}
