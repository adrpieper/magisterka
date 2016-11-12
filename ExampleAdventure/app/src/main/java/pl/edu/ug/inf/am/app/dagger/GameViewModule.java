package pl.edu.ug.inf.am.app.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.adventure.AStagePresenter;
import pl.edu.ug.inf.am.GameStageStateProvider;
import pl.edu.ug.inf.am.adventure.AdventureViewManager;
import pl.edu.ug.inf.am.adventure.controller.AStagePresenterImpl;
import pl.edu.ug.inf.am.view.*;
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
    public AStagePresenter provideAStageDisplayer(DiComponent diComponent, FragmentDisplayer fragmentDisplayer, GameStageStateProvider stateProvider) {
        return new AStagePresenterImpl(diComponent, fragmentDisplayer, stateProvider);
    }

    @Provides
    @Singleton
    public FragmentDisplayer provideFragmentDisplayer() {
        return gameActivity;
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
    public MainController provideViewManage(StageViewManagers stageViewManagers, DiComponent diComponent){
        return new MainControllerImpl(gameActivity,stageViewManagers);
    }
}
