package pl.edu.ug.inf.am.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import pl.edu.ug.inf.am.app.dagger.AppComponent;
import pl.edu.ug.inf.am.game.view.GameActivity;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = null;
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                if (activity instanceof GameActivity) {
                    appComponent.appStagesManager().startOrResumeGame((GameActivity) activity);
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
