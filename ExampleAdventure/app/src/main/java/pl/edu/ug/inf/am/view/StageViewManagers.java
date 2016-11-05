package pl.edu.ug.inf.am.view;

import pl.edu.ug.inf.am.stage.GameStage;

import java.util.EnumMap;
import java.util.Map;



public class StageViewManagers {

    private Map<GameStage, StageViewManager> map = new EnumMap<>(GameStage.class);

    public void add(GameStage gameStage, StageViewManager manager) {
        map.put(gameStage, manager);
    }

    public StageViewManager get(GameStage gameStage) {
        return map.get(gameStage);
    }
}
