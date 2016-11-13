package pl.edu.ug.inf.am.app.stage;

import pl.edu.ug.inf.am.app.dagger.AppComponent;
import pl.edu.ug.inf.am.app.dagger.PerApp;
import pl.edu.ug.inf.am.common.StagesManager;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.game.view.GameActivity;

import javax.inject.Inject;

@PerApp
public class AppStagesManager extends StagesManager{

    private final AppComponent appComponent;
    private GameComponent gameComponent = null;

    @Inject
    public AppStagesManager(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    public void startOrResumeGame(GameActivity gameActivity) {
        if (gameComponent == null){
            gameComponent = appComponent.gameComponent();
            gameComponent.gameViewContainer().bindActivity(gameActivity);
            start(gameComponent.gameStage());
        }else {
            gameComponent.gameViewContainer().bindActivity(gameActivity);
            onResume();
        }
    }
}
