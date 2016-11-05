package pl.edu.ug.inf.am.stage;

import pl.edu.ug.inf.am.state.GameState;
import pl.edu.ug.inf.am.state.GameStateManager;
import pl.edu.ug.inf.am.view.ViewManage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StageManager {

    private final ViewManage viewManage;
    private final GameStateManager gameStateManager;

    @Inject
    public StageManager(ViewManage viewManage, GameStateManager gameStateManager) {
        this.viewManage = viewManage;
        this.gameStateManager = gameStateManager;
    }

    public void changeStage(GameStage gameStage, StageState stageState){
        GameState gameState = gameStateManager.getGameState();
        gameState.setGameStage(gameStage);
        gameState.setStageState(stageState);
        viewManage.show(gameState);
    }
}
