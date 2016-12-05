package pl.edu.ug.inf.am.adventure.result.dagger;

import dagger.Component;
import dagger.Subcomponent;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.result.view.AdventureResultFragment;
import pl.edu.ug.inf.am.adventure.result.view.LevelAchievedFragment;

@Subcomponent
@PerAdventureStage
public interface AdventureResultComponent {

    void inject(AdventureResultFragment adventureResultFragment);
    void inject(LevelAchievedFragment levelAchievedFragment);
}
