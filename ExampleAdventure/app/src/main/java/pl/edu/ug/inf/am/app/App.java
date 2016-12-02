package pl.edu.ug.inf.am.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import pl.edu.ug.inf.am.app.dagger.AppComponent;
import pl.edu.ug.inf.am.app.dagger.AppModule;
import pl.edu.ug.inf.am.app.dagger.DaggerAppComponent;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.game.view.GameActivity;

public class App extends Application {

    private AppComponent appComponent;

    public static <T> T getComponent(Class<T> componentInterface) {
        return componentsManager.get(componentInterface);
    }

    private static ComponentsManager componentsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(getApplicationContext())).build();
        componentsManager = appComponent.componentsManager();
        componentsManager.add(AppComponent.class, appComponent);
        appComponent.subComponentsManager().prepareNewGame();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof GameActivity) {
                    appComponent.subComponentsManager().runGame((GameActivity) activity);
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
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

}
