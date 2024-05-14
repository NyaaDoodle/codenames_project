package engine.gameinstance;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordCardSet {
    private final Set<String> wordCardSet = new HashSet<>();

    public WordCardSet() {}

    public Set<String> getWordCardSet() { return Collections.unmodifiableSet(wordCardSet); }

    public void addWords(final Collection<String> words, final boolean setAsBlackWords) {

    }
}
