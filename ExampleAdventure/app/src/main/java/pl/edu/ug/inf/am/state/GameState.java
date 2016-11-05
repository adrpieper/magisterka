package pl.edu.ug.inf.am.state;

import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.stage.GameStage;
import pl.edu.ug.inf.am.stage.StageState;

/**
 * Created by Adi on 2016-11-02.
 */
public class GameState {
    private GameStage gameStage = GameStage.TRIP;
    private StageState stageState = null;
    private PlayerState playerState = new PlayerState();

    public void setStageState(StageState stageState) {
        this.stageState = stageState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setGameStage(GameStage gameStage) {
        this.gameStage = gameStage;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    public <T extends StageState> T getStageState() {
        return (T) stageState;
    }
}
