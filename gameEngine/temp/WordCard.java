public class WordCard {
    private final String word;
    private final Team team;
    private final int index;
    private boolean found = false;
    public WordCard(String word, Team team, int index);
    public String getWord();
    public Team getTeam();
    public int getIndex();
    public boolean wasFound();
}
