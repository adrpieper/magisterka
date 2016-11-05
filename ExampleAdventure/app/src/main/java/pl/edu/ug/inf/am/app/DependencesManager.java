package pl.edu.ug.inf.am.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import pl.edu.ug.inf.am.app.dagger.DaggerDiComponent;
import pl.edu.ug.inf.am.app.dagger.DiComponent;
import pl.edu.ug.inf.am.app.dagger.GameViewModule;
import pl.edu.ug.inf.am.view.GameActivity;

/**
 * Created by Adi on 2016-10-11.
 */
public class DependencesManager implements Application.ActivityLifecycleCallbacks {

    private DiComponent diComponent;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof GameActivity) {
            GameActivity gameActivity = (GameActivity) activity;
            diComponent = DaggerDiComponent.builder().gameViewModule(new GameViewModule(gameActivity)).build();
            diComponent.inject(gameActivity);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        diComponent.viewManage().show(diComponent.gameStateManager().getGameState());
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        diComponent = null;
    }
}
