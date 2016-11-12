package pl.edu.ug.inf.am.app.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.AdventureEngine;
import pl.edu.ug.inf.am.GameStageStateProvider;
import pl.edu.ug.inf.am.adventure.AdventureEngineImpl;

import javax.inject.Singleton;

@Module
public class StagesModule {


    @Provides
    @Singleton
    public AdventureEngine initializer(GameStageStateProvider provider){
        return new AdventureEngineImpl(provider);
    }
}
