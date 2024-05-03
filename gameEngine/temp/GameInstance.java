public class GameInstance {
    private final List<Team> teams;
    private final Board board;
    private List<WordCard> words;
    private Hint currentHint;
    private Map<Team, int> teamToScore;

    public GameInstance(GameStructure gameStructure);
    public List<Team> getTeams();
    public Board getBoard();
    public List<WordCard> getWords();
    public Hint getCurrentHint();
    public void setCurrentHint();
    public Map<Team, int> getTeamToScore();
}
