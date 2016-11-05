package pl.edu.ug.inf.am.adventure;

import pl.aml.Monster;
import pl.edu.ug.inf.am.adventure.model.ResultModel;
import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.stage.GameStage;
import pl.edu.ug.inf.am.stage.StageManager;
import pl.edu.ug.inf.am.stage.StageState;
import pl.edu.ug.inf.am.state.GameStateManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ResultAccepter {

    private final GameStateManager gameStateManager;
    private final StageManager stageManager;

    @Inject
    public ResultAccepter(GameStateManager gameStateManager, StageManager stageManager) {
        this.gameStateManager = gameStateManager;
        this.stageManager = stageManager;
    }

    public ResultModel createResultModel() {

        final AdventureState stageState = gameStateManager.getGameState().getStageState();
        int exp = 0;
        for (Monster monster : stageState.getKilledMonsters()) {
            exp += 100;
        }
        return new ResultModel(exp);
    }

    public void acceptResult(ResultModel result) {
        final PlayerState playerState = gameStateManager.getGameState().getPlayerState();
        int actualExp = playerState.getExperience();
        playerState.setExperience(actualExp + result.getGainedExp());
        stageManager.changeStage(GameStage.TRIP, null);
    }
}
