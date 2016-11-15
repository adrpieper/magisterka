package pl.edu.ug.inf.am.adventure.dagger;

import pl.aml.AStage;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.dagger.AdventureComponent;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightModule;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionComponent;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionModule;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.adventure.question.view.QuestionFragment;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.SubComponentManager;
import pl.edu.ug.inf.am.game.dagger.GameSubComponentManager;

import javax.inject.Inject;
import java.util.List;

@PerAdventure
public class AdventureSubComponentManager extends SubComponentManager {

    private final AdventureComponent adventureComponent;
    private final GameSubComponentManager gameStagesManager;

    @Inject
    public AdventureSubComponentManager(ComponentsManager componentsManager, AdventureComponent adventureComponent, GameSubComponentManager gameStagesManager) {
        super(componentsManager);
        this.adventureComponent = adventureComponent;
        this.gameStagesManager = gameStagesManager;
    }

    public void startQuestion(QuestionState questionState) {
        QuestionComponent questionComponent = adventureComponent.questionComponent(new QuestionModule(questionState));
        setSubcomponent(QuestionComponent.class, questionComponent);
        questionComponent.gameView().showFragment(new QuestionFragment());
    }

    public void startFight(List<MonsterType> monsters, AStage doOnWin, AStage doOnLost) {

        FightComponent fightComponent = adventureComponent.fightComponent();
        setSubcomponent(FightComponent.class, fightComponent);
        fightComponent.fightModel().setMonstersToKill(monsters);
        fightComponent.fightNavigator().setAfterFightStages(doOnWin, doOnLost);
        fightComponent.fightNavigator().showFight();
    }

    public void endAdventure() {
        gameStagesManager.startTrip();
    }
}
