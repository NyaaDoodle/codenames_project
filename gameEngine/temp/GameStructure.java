public class GameStructure {
    private final Words words;
    private final Board board;
    private final List<TeamStructure> teams;
    public GameStructure(Words words, Board board, Collection<TeamStructure> teams);
    public Words getWords();
    public Board getBoard();
    public List<TeamStructure> getTeams();
}
