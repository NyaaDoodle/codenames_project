package engine.jaxb.generated;

import engine.gamestructure.Board;
import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.gamestructure.Words;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.*;

public class JAXBConversion {
    private final static String GENERATED_XJC_CLASSES_PACKAGE = "engine.jaxb.generated";
    private final static String splitDelimiters = " ";
    public static GameStructure XMLToObjectsConversion(InputStream inputStream) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(GENERATED_XJC_CLASSES_PACKAGE);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ECNGame ecnGame = (ECNGame) unmarshaller.unmarshal(inputStream);
        Words outWords = convertECNWordsToEngineWords(ecnGame.getECNWords());
        Board outBoard = convertECNBoardToEngineBoard(ecnGame.getECNBoard());
        List<Team> outTeams = convertECNTeamsToEngineTeams(ecnGame.getECNTeam1(), ecnGame.getECNTeam2());
        return new GameStructure(outWords, outBoard, outTeams);
    }
    private static Words convertECNWordsToEngineWords(ECNWords ecnWords) {
        final String ecnGameWords = ecnWords.getECNGameWords();
        final Set<String> gameWords = new HashSet<>(Arrays.asList(ecnGameWords.split(splitDelimiters)));
        final String ecnBlackWords = ecnWords.getECNBlackWords();
        final Set<String> blackWords = new HashSet<>(Arrays.asList(ecnBlackWords.split(splitDelimiters)));
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
}
