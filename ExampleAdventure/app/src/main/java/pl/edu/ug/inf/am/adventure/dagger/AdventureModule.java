package pl.edu.ug.inf.am.adventure.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.adventure.AContext;
import pl.aml.adventure.AdventureEngine;
import pl.edu.ug.inf.am.adventure.AContextImpl;
import pl.edu.ug.inf.am.adventure.AdventureEngineImpl;
import pl.edu.ug.inf.am.adventure.state.AdventureState;

@Module
public class AdventureModule {

    @Provides
    @PerAdventure
    public AContext provideAContext(){
        return new AContextImpl();
    }

    @Provides
    @PerAdventure
    public AdventureEngine provideEngine(AdventureState adventureState, AdventureSubComponentManager adventureStagesManager, AContext aContext){
        return new AdventureEngineImpl(adventureState, adventureStagesManager, aContext);
    }
}
