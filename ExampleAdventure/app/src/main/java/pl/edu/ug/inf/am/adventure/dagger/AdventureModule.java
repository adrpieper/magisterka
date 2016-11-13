package pl.edu.ug.inf.am.adventure.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.AdventureEngine;
import pl.edu.ug.inf.am.adventure.AdventureEngineImpl;
import pl.edu.ug.inf.am.adventure.stage.AdventureStagesManager;
import pl.edu.ug.inf.am.adventure.state.AdventureState;

@Module
public class AdventureModule {

    @Provides
    @PerAdventure
    public AdventureEngine provideEngine(AdventureState adventureState, AdventureStagesManager adventureStagesManager){
        return new AdventureEngineImpl(adventureState, adventureStagesManager);
    }
}
