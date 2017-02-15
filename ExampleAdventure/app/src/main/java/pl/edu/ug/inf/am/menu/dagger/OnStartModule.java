package pl.edu.ug.inf.am.menu.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.impl.start.AdventuresOnStart;

@Module
public class OnStartModule {

    @PerMenu
    @Provides
    public AdventuresOnStart provideAdventuresOnStart(){
        return new AdventuresOnStart();
    }

}
