package engine.gameinstance;

import engine.gamestructure.GameStructure;
import engine.gamestructure.Team;

import java.util.*;
import java.util.stream.Collectors;

public class GameInstance {
    private final GameStructure gameStructure;
    private Set<WordCard> words = new HashSet<>();
    private Map<Team, Integer> teamToScore = new HashMap<>();
    private Hint currentHint;
    public GameInstance(GameStructure gameStructure) {
        this.gameStructure = gameStructure;
        final Set<String> gameWords = gameStructure.getWords().getGameWords();
        final Set<String> blackWords = gameStructure.getWords().getBlackWords();
        final int gameWordsAmount = gameStructure.getBoard().getCardCount();
        final int blackWordsAmount = gameStructure.getBoard().getBlackCardCount();
        Set<String> drawnGameWords = drawWordsFromWordBank(gameWords, gameWordsAmount);
        Set<String> drawnBlackWords = drawWordsAndCheckIfExistsAtOtherBank(blackWords, drawnGameWords, blackWordsAmount);

    }

    public GameStructure getGameStructure() {
        return gameStructure;
    }

    public Hint getCurrentHint() {
        return currentHint;
    }

    public void setCurrentHint(Hint currentHint) {
        this.currentHint = currentHint;
    }

    public Set<WordCard> getWords() {
        return Collections.unmodifiableSet(words);
    }

    public Map<Team, Integer> getTeamToScore() {
        return Collections.unmodifiableMap(teamToScore);
    }

    private <E> Optional<E> getRandomMemberFromCollection(Collection<E> collection) {
        return collection.stream().skip((long) (collection.size() * Math.random())).findFirst();
    }

    private Set<String> drawWordsFromWordBank(final Collection<String> wordBank, final int drawAmount) {
        // BUG Infinite loop when empty set is passed
        Set<String> drawnWords = new HashSet<>();
        while (wordBank.size() == drawAmount) {
            getRandomMemberFromCollection(wordBank).ifPresent(drawnWords::add);
        }
        return drawnWords;
    }
    private Set<String> drawWordsAndCheckIfExistsAtOtherBank(final Collection<String> sourceBank, final Collection<String> checkBank, final int drawAmount) {
        // BUG Infinite loop when empty set is passed
        Set<String> drawnWords = new HashSet<>();
        while (sourceBank.size() == drawAmount) {
            getRandomMemberFromCollection(sourceBank).ifPresent((word) -> {
                if (!(checkBank.contains(word))) { sourceBank.add(word); }
            });
        }
        return drawnWords;
    }
    private void addFromCollectionToWordCardSet()
}
