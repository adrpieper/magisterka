package pl.edu.ug.inf.am.app.dagger;

import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.SubComponentManager;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.game.view.GameActivity;

import javax.inject.Inject;

@PerApp
public class AppSubComponentManager extends SubComponentManager {

    private final AppComponent appComponent;
    private GameComponent gameComponent = null;

    @Inject
    public AppSubComponentManager(ComponentsManager componentsManager, AppComponent appComponent) {
        super(componentsManager);
        this.appComponent = appComponent;
    }

    public void startOrResumeGame(GameActivity gameActivity) {
        if (getComponentInterface() != GameComponent.class){
            gameComponent = appComponent.gameComponent();
            gameComponent.gameViewContainer().bindActivity(gameActivity);
            setSubcomponent(GameComponent.class, gameComponent);
            gameComponent.subComponentsManager().startTrip();
        }else {
            gameComponent.gameViewContainer().bindActivity(gameActivity);
        }
    }
}
