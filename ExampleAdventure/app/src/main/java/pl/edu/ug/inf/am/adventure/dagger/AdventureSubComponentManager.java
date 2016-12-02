package pl.edu.ug.inf.am.adventure.dagger;

import pl.aml.adventure.AStage;
import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightComponent;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionComponent;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionModule;
import pl.edu.ug.inf.am.adventure.question.view.QuestionFragment;
import pl.edu.ug.inf.am.adventure.result.dagger.AdventureResultComponent;
import pl.edu.ug.inf.am.adventure.result.view.AdventureResultFragment;
import pl.edu.ug.inf.am.common.ComponentsManager;
import pl.edu.ug.inf.am.common.SubComponentManager;
import pl.edu.ug.inf.am.game.dagger.GameSubComponentManager;
import pl.edu.ug.inf.am.game.view.GameView;

import javax.inject.Inject;
import java.util.List;

@PerAdventure
public class AdventureSubComponentManager extends SubComponentManager {

    private final AdventureComponent adventureComponent;
    private final GameSubComponentManager gameStagesManager;
    private final GameView gameView;

    @Inject
    public AdventureSubComponentManager(ComponentsManager componentsManager, AdventureComponent adventureComponent, GameSubComponentManager gameStagesManager, GameView gameView) {
        super(componentsManager);
        this.adventureComponent = adventureComponent;
        this.gameStagesManager = gameStagesManager;
        this.gameView = gameView;
    }

    public void startQuestion(QuestionState questionState) {
        QuestionComponent questionComponent = adventureComponent.questionComponent(new QuestionModule(questionState));
        setSubcomponent(QuestionComponent.class, questionComponent);
        gameView.showFragment(new QuestionFragment());
    }

    public void startFight(List<MonsterType> monsters, AStage doOnWin, AStage doOnLost) {

        FightComponent fightComponent = adventureComponent.fightComponent();
        setSubcomponent(FightComponent.class, fightComponent);
        fightComponent.fightPreparation().prepare(monsters);
        fightComponent.fightNavigator().setAfterFightStages(doOnWin, doOnLost);
        fightComponent.fightNavigator().showFight();
    }

    public void showAdventureResult(){
        AdventureResultComponent adventureResultComponent = adventureComponent.adventureResultComponent();
        setSubcomponent(AdventureResultComponent.class, adventureResultComponent);
        gameView.showFragment(new AdventureResultFragment());
    }

    public void endAdventure() {
        gameStagesManager.startTrip();
    }
}
