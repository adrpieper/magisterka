package pl.edu.ug.inf.am.adventure.fight.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;

@Module
public class FightModule {

    private final FightState fightState;

    public FightModule(FightState fightState) {
        this.fightState = fightState;
    }

    @Provides
    @PerAdventureStage
    public FightState provideFightState() {
        return fightState;
    }
}
