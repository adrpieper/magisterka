package pl.edu.ug.inf.am.game.stage;

import pl.edu.ug.inf.am.common.StageLifecycle;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class GameStage implements StageLifecycle<Void> {

    private final GameStagesManager gameStagesManager;

    @Inject
    public GameStage(GameStagesManager gameStagesManager) {
        this.gameStagesManager = gameStagesManager;
    }

    @Override
    public void onStart(Void startData) {
        gameStagesManager.startTrip();
    }

    @Override
    public void onResume() {
        gameStagesManager.onResume();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onEnd() {

    }
}
