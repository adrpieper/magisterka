package pl.edu.ug.inf.am.stage;

import pl.edu.ug.inf.am.state.GameState;
import pl.edu.ug.inf.am.state.GameStateManager;
import pl.edu.ug.inf.am.view.MainController;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StageManager {

    private final MainController mainController;
    private final GameStateManager gameStateManager;

    @Inject
    public StageManager(MainController mainController, GameStateManager gameStateManager) {
        this.mainController = mainController;
        this.gameStateManager = gameStateManager;
    }

    public void changeStage(GameStage gameStage, StageState stageState){
        GameState gameState = gameStateManager.getGameState();
        gameState.setGameStage(gameStage);
        gameState.setStageState(stageState);
        mainController.show(gameState);
    }
}
