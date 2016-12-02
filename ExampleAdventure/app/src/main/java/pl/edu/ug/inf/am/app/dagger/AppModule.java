package pl.edu.ug.inf.am.app.dagger;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @PerApp
    public Context getContext() {
        return context;
    }
}
