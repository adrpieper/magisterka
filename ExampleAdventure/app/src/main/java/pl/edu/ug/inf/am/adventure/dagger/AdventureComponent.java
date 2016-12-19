package pl.edu.ug.inf.am.adventure.dagger;

import dagger.Subcomponent;
import pl.aml.adventure.AdventureEngine;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.message.view.ShowMessageFragment;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionComponent;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionModule;
import pl.edu.ug.inf.am.adventure.result.dagger.AdventureResultComponent;

@PerAdventure
@Subcomponent(modules = {AdventureModule.class})
public interface AdventureComponent {

    AdventureEngine adventureEngine();

    QuestionComponent questionComponent(QuestionModule questionModule);
    FightComponent fightComponent();
    AdventureResultComponent adventureResultComponent();

    void inject(ShowMessageFragment showMessageFragment);
}
