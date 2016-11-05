package pl.edu.ug.inf.am.app.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.adventure.AdventureViewManager;
import pl.edu.ug.inf.am.view.StageViewManagers;
import pl.edu.ug.inf.am.view.ViewManage;
import pl.edu.ug.inf.am.view.ViewManageImpl;
import pl.edu.ug.inf.am.view.GameActivity;
import pl.edu.ug.inf.am.stage.GameStage;
import pl.edu.ug.inf.am.trip.TripStageViewManager;

import javax.inject.Singleton;

@Module
public class GameViewModule {

    private final GameActivity gameActivity;

    public GameViewModule(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
    }

    @Provides
    @Singleton
    public GameActivity provideGameActivity() {
        return gameActivity;
    }

    @Provides
    @Singleton
    public StageViewManagers provideStageViewManagers(
            TripStageViewManager tripStageViewManager,
            AdventureViewManager adventureViewManager
    ){
        StageViewManagers managers = new StageViewManagers();
        managers.add(GameStage.TRIP, tripStageViewManager);
        managers.add(GameStage.ADVENTURE, adventureViewManager);
        return managers;
    }

    @Provides
    @Singleton
    public ViewManage provideViewManage(StageViewManagers stageViewManagers, DiComponent diComponent){
        return new ViewManageImpl(gameActivity,stageViewManagers);
    }
}
