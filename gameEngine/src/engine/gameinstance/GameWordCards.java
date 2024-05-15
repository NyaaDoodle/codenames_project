package engine.gameinstance;

import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;
import engine.gamestructure.Words;

import java.util.*;

public class GameWordCards {
    private final static Team DEFAULT_VALUE_TEAM = new Team("", 0);
    private final List<WordCard> wordCards = new ArrayList<>();
    private final Words wordBanks;
    private final Set<Team> teams;
    private final int gameCardsCount;
    private final int blackCardsCount;

    public GameWordCards(GameStructure gameStructure) {
        this(gameStructure.getWords(), gameStructure.getTeams(), gameStructure.getBoard().getCardCount(), gameStructure.getBoard().getBlackCardCount());
    }

    public GameWordCards(Words wordBanks, Set<Team> teams, int gameCardsCount, int blackCardsCount) {
        this.wordBanks = wordBanks;
        this.teams = teams;
        this.gameCardsCount = gameCardsCount;
        this.blackCardsCount = blackCardsCount;
        populateWordCards();
    }

    public List<WordCard> getWordCardList() { return Collections.unmodifiableList(wordCards); }

    private void populateWordCards() {
        Set<String> drawnGameWords = drawWordsFromWordBank(wordBanks.getGameWords(), gameCardsCount);
        Set<String> drawnBlackWords = drawWordsAndCheckIfExistsAtOtherBank(wordBanks.getBlackWords(), drawnGameWords, blackCardsCount);
        int skipCount = 0;
        for (Team team : teams) {
            drawnGameWords.stream().skip(skipCount).limit(team.getCardCount()).forEach((word) -> wordCards.add(new WordCard(word, team, false)));
            skipCount += team.getCardCount();
        }
        drawnBlackWords.stream().forEach((word) -> wordCards.add(new WordCard(word, DEFAULT_VALUE_TEAM, true)));
        Collections.shuffle(wordCards);
    }

    private <E> Optional<E> getRandomMemberFromCollection(Collection<E> collection) {
        return collection.stream().skip((long) (collection.size() * Math.random())).findFirst();
    }

    private Set<String> drawWordsFromWordBank(final Collection<String> wordBank, final int drawAmount) {
        Set<String> drawnWords = new HashSet<>();
        while (drawnWords.size() != drawAmount) {
            getRandomMemberFromCollection(wordBank).ifPresent(drawnWords::add);
        }
        return drawnWords;
    }
    private Set<String> drawWordsAndCheckIfExistsAtOtherBank(final Collection<String> sourceBank, final Collection<String> checkBank, final int drawAmount) {
        Set<String> drawnWords = new HashSet<>();
        while (drawnWords.size() != drawAmount) {
            getRandomMemberFromCollection(sourceBank).ifPresent((word) -> {
                if (!(checkBank.contains(word))) { drawnWords.add(word); }
            });
        }
        return drawnWords;
    }

    @Override
    public String toString() {
        return "GameWordCards{" +
                "wordCards=" + wordCards +
                '}';
    }
}
