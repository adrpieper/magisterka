package pl.edu.ug.inf.am.adventure.stage;

import pl.edu.ug.inf.am.adventure.dagger.AdventureComponent;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.adventure.fight.dagger.FightModule;
import pl.edu.ug.inf.am.adventure.question.state.QuestionState;
import pl.edu.ug.inf.am.adventure.question.dagger.QuestionModule;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.common.StagesManager;
import pl.edu.ug.inf.am.game.stage.GameStagesManager;

import javax.inject.Inject;

@PerAdventure
public class AdventureStagesManager extends StagesManager{

    private final AdventureComponent adventureComponent;
    private final GameStagesManager gameStagesManager;

    @Inject
    public AdventureStagesManager(AdventureComponent adventureComponent, GameStagesManager gameStagesManager) {
        this.adventureComponent = adventureComponent;
        this.gameStagesManager = gameStagesManager;
    }

    public void startQuestion(QuestionState questionState) {
        start(adventureComponent.questionComponent(new QuestionModule(questionState)).questionLifecycleCallbacks(),null);
    }

    public void startFight(FightState state) {
        start(adventureComponent.fightComponent(new FightModule(state)).fightLifecycleCallbacks(), null);
    }

    public void endAdventure() {
        onEnd();
        gameStagesManager.startTrip();
    }
}
