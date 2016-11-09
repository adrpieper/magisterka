package pl.edu.ug.inf.am.app.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.AStageInitializer;
import pl.edu.ug.inf.am.GameStageStateProvider;
import pl.edu.ug.inf.am.adventure.state.AStageInitializerImpl;

import javax.inject.Singleton;

@Module
public class StagesModule {


    @Provides
    @Singleton
    public AStageInitializer initializer(GameStageStateProvider provider){
        return new AStageInitializerImpl(provider);
    }
}
