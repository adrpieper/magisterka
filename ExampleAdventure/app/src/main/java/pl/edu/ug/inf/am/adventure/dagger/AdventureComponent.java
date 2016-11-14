package pl.edu.ug.inf.am.adventure.dagger;

import dagger.Subcomponent;
import pl.aml.AdventureEngine;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightModule;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionComponent;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionModule;

@PerAdventure
@Subcomponent(modules = {AdventureModule.class})
public interface AdventureComponent {

    AdventureEngine adventureEngine();

    QuestionComponent questionComponent(QuestionModule questionModule);
    FightComponent fightComponent(FightModule fightModule);

}
