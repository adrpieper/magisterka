package pl.edu.ug.inf.am.app.dagger;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

import java.util.Random;

@Module
public class AppModule {
    private final Context context;
    private final Random random = new Random();

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @PerApp
    public Context getContext() {
        return context;
    }

    @Provides
    @PerApp
    public Random provideRandom() {
        return random;
    }
}
