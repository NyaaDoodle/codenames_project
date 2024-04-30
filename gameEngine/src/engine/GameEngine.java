package engine;

import engine.gamestructure.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GameEngine implements CodenamesEngine {
    private GameStructure currentGameData = new GameStructure();

    public GameEngine() {

    }

    @Override
    public boolean readFromDescriptorFile(String fileName) {
        Set<String> testGameWords = Arrays.asSet("encapsulation", "german", "poland", "kombat",
                "waffele", "whom", "leg", "character", "terms", "else", "camel", "rabbit", "fire",
                "text", "element", "sky", "item", "robot", "past", "dune", "dolphine", "then",
                "it", "am", "quality", "eye", "moon", "system", "folder", "light", "letter",
                "number", "notch", "allies", "dog", "word", "hash", "why", "gun", "pink", "what",
                "yellow", "sea", "see", "noon", "file", "top", "does", "ear", "can't", "table",
                "foot", "hand", "a", "strike", "black", "electricity", "pistol", "kill", "boat",
                "democracy", "off", "battle", "single", "fly", "component", "blue", "watch",
                "reflector", "future", "machine", "progress", "atom", "under", "inferno",
                "voice", "rotor", "tonight"); // Length: 78
        Set<String> testBlackWords = Arrays.asList("mouce", "door", "data", "use", "doom", "sign",
                "screen", "do", "bomb", "red", "later", "whale", "white", "hello", "than", "which",
                "england", "morning", "dirt", "tree", "thrown", "water", "trash", "ranch", "she",
                "sand", "squad", "desk", "present", "where", "magenta", "game", "code", "enigma",
                "plural", "death", "vegtable", "fruit", "for", "their", "privacy", "back", "house",
                "fox", "not", "hair", "napkin", "and", "street", "cat", "now", "of", "iteration",
                "class", "trike", "fight", "mortal", "live", "how", "on", "patrol", "keyboard",
                "midnight", "or", "green", "umbrella", "wheel", "saw", "orange", "airplane",
                "window", "front"); // Length: 72
        Words testWords = new Words(testGameWords, testBlackWords);
        Board testBoard = new Board(24, 1, 5, 5);
        Team team1 = new Team("Alpha", 10);
        Team team2 = new Team("Bravo", 10);
        List<Team> testTeams = Arrays.asList(team1, team2);
        currentGameData.setWords(testWords);
        currentGameData.setBoard(testBoard);
        currentGameData.setTeams(testTeams);
        return false;
    }

    @Override
    public GameStructureData getCurrentGameStructureDetails() {
        return new GameStructureData(currentGameData);
    }

    @Override
    public void beginGame() {

    }

    @Override
    public boolean makeTurn() {
        return false;
    }

    @Override
    public void currentGameStatus() {

    }

    @Override
    public void closeGame() {

    }
}
