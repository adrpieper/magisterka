package pl.edu.ug.inf.am.adventure.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.adventure.AContext;
import pl.aml.adventure.AdventureEngine;
import pl.edu.ug.inf.am.adventure.AContextImpl;
import pl.edu.ug.inf.am.adventure.AdventureEngineImpl;
import pl.edu.ug.inf.am.adventure.model.AdventurePlayerModel;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.adventure.AdventuresManager;

@Module
public class AdventureModule {

    @Provides
    @PerAdventure
    public AContext provideAContext(AContextImpl context){
        return context;
    }

    @Provides
    @PerAdventure
    public AdventureEngine provideEngine(AdventureState adventureState, AdventureSubComponentManager adventureStagesManager, AContext aContext, AdventuresManager adventuresManager){
        return new AdventureEngineImpl(adventureState, adventuresManager, adventureStagesManager, aContext);
    }
}
