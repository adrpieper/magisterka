package pl.edu.ug.inf.am.adventure.fight.dagger;

import dagger.Module;
import dagger.Provides;
import pl.aml.character.FightValues;
import pl.edu.ug.inf.am.adventure.AContextImpl;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;

@Module
public class FightModule {

    @Provides
    @PerAdventureStage
    public FightValues provideFightValues(AContextImpl context){
        return context;
    }
}
