package pl.edu.ug.inf.am.view;

import pl.edu.ug.inf.am.state.GameState;


public class ViewManageImpl implements ViewManage {

    private final GameActivity gameActivity;
    private final StageViewManagers stageViewManagers;

    public ViewManageImpl(GameActivity gameActivity, StageViewManagers stageViewManagers) {
        this.gameActivity = gameActivity;
        this.stageViewManagers = stageViewManagers;
    }

    @Override
    public void show(GameState gameState) {
        StageViewManager stageViewManager = stageViewManagers.get(gameState.getGameStage());
        stageViewManager.showState(gameState.getStageState(), gameActivity);
    }
}
