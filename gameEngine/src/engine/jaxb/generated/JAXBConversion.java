package engine.jaxb.generated;

import engine.exceptions.GameStructureFileException;
import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.gamestructure.Words;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class JAXBConversion {
    private final static String GENERATED_XJC_CLASSES_PACKAGE = "engine.jaxb.generated";
    private final static String splitDelimiters = "\\s";
    public static GameStructure XMLToObjectsConversion(InputStream inputStream) throws JAXBException, GameStructureFileException {
        JAXBContext jaxbContext = JAXBContext.newInstance(GENERATED_XJC_CLASSES_PACKAGE);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ECNGame ecnGame = (ECNGame) unmarshaller.unmarshal(inputStream);
        Words outWords = convertECNWordsToEngineWords(ecnGame.getECNWords());
        Board outBoard = convertECNBoardToEngineBoard(ecnGame.getECNBoard());
        List<Team> outTeams = convertECNTeamsToEngineTeams(ecnGame.getECNTeam1(), ecnGame.getECNTeam2());
        checkValidity(outWords, outBoard, outTeams);
        return new GameStructure(outWords, outBoard, outTeams);
    }
    private static Words convertECNWordsToEngineWords(ECNWords ecnWords) {
        final String ecnGameWords = ecnWords.getECNGameWords();
        Set<String> gameWords = new HashSet<>(Arrays.asList(ecnGameWords.split(splitDelimiters)));
        gameWords = removeBlankWords(gameWords);
        final String ecnBlackWords = ecnWords.getECNBlackWords();
        Set<String> blackWords = new HashSet<>(Arrays.asList(ecnBlackWords.split(splitDelimiters)));
        blackWords = removeBlankWords(blackWords);
        return new Words(gameWords, blackWords);
    }
    private static Board convertECNBoardToEngineBoard(ECNBoard ecnBoard) {
        final int cardsCount = ecnBoard.getCardsCount();
        final int blackCardsCount = ecnBoard.getBlackCardsCount();
        ECNLayout ecnLayout = ecnBoard.getECNLayout();
        final int rows = ecnLayout.getRows();
        final int columns = ecnLayout.getColumns();
        return new Board(cardsCount, blackCardsCount, rows, columns);
    }
    private static List<Team> convertECNTeamsToEngineTeams(ECNTeam1 ecnTeam1, ECNTeam2 ecnTeam2) {
        // Currently, it's hardcoded for only two teams.
        Team team1 = new Team(ecnTeam1.getName(), ecnTeam1.getCardsCount());
        Team team2 = new Team(ecnTeam2.getName(), ecnTeam2.getCardsCount());
        return new ArrayList<>(Arrays.asList(team1, team2));
    }
    private static Set<String> removeBlankWords(final Collection<String> wordBank) {
        return wordBank.stream().filter((word) -> !(word.trim().isEmpty())).collect(Collectors.toSet());
    }
    private static void checkValidity(Words words, Board board, List<Team> teams) throws GameStructureFileException {
        if (board.getCardCount() > words.getGameWords().size()) {
            throw new GameStructureFileException("Amount of regular words in a game is greater than the amount of words in the word bank: "
                    + board.getCardCount() + " > " + words.getGameWords().size()
                    + "\nCorrect the \"cards-count\" in the XML file to be less than " + words.getGameWords().size());
        }
        if (board.getBlackCardCount() > words.getBlackWords().size()) {
            throw new GameStructureFileException("Amount of black words in a game is greater than the amount of black words in the word bank: "
                    + board.getBlackCardCount() + " > " + words.getBlackWords().size()
                    + "\nCorrect the \"black-cards-count\" in the XML file to be less than " + words.getBlackWords().size());
        }
        final int totalTeamsCards = teams.stream().mapToInt(Team::getCardCount).sum();
        if (totalTeamsCards > board.getCardCount()) {
            throw new GameStructureFileException("The amount of cards assigned for both teams is greater than the amount of regular cards available in a game: "
                    + totalTeamsCards + " > " + board.getCardCount()
                    + "\nCorrect the values of \"cards-count\" in the XML file for each team, so that the sum is less than " + board.getCardCount());
        }
        final int cardsTableSize = board.getRows() * board.getColumns();
        final int totalCardsInGame = board.getCardCount() + board.getBlackCardCount();
        if (cardsTableSize < totalCardsInGame) {
            throw new GameStructureFileException("The specified rows and columns result in a product less than the amount of total cards in the game: "
            + board.getRows() + " * " + board.getColumns() + " < " + totalCardsInGame
            + "\nCorrect the values of \"rows\" and \"columns\" in the XML file so that their product is equal or more than " + totalCardsInGame);
        }
        if (teams.get(0).getName().equals(teams.get(1).getName())) {
            throw new GameStructureFileException("Both teams share the same name: " + teams.get(0).getName() + "\nPlease give a different name to one of the teams.");
        }
    }
}
