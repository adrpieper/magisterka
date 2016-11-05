package pl.edu.ug.inf.am.app;

import android.app.Application;

/**
 * Created by Adi on 2016-10-11.
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new DependencesManager());
    }
}
