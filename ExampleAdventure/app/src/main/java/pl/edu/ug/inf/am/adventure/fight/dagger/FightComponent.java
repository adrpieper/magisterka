package pl.edu.ug.inf.am.adventure.fight.dagger;

import dagger.Subcomponent;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.controller.FightNavigator;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.view.FightFragment;
import pl.edu.ug.inf.am.adventure.fight.view.WinFragment;

@PerAdventureStage
@Subcomponent(modules = FightModule.class)
public interface FightComponent {

    FightNavigator fightNavigator();
    FightModel fightModel();
    void inject(FightFragment fightFragment);
    void inject(WinFragment winFragment);
}
