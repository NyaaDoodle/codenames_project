package engine.gameinstance;

import engine.gamestructure.GameStructureData;

import java.util.HashSet;
import java.util.Set;

public class GameInstance {
    GameStructureData gameStructure;
    Set<String> gameWords = new HashSet<>();
    Set<String> blackWords = new HashSet<>();
}
