package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.logic.FightFlowSteps;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;

import javax.inject.Inject;

@PerAdventureStage
public class FightController {

    private final FightModel fightModel;
    private final FightFlowSteps fightFlowSteps;
    private final ResultController resultController;

    @Inject
    public FightController(FightModel fightModel, FightFlowSteps fightFlowSteps, ResultController resultController) {
        this.fightModel = fightModel;
        this.fightFlowSteps = fightFlowSteps;
        this.resultController = resultController;
    }

    public void nextOpponent() {
        fightFlowSteps.nextMonster();
    }

    public void enemyAttack() {
        fightFlowSteps.enemyAttack();
        if (fightModel.getFightStatus().isEnd()) {
            resultController.calculateAndShowResult();
        }
    }

    public void playerAttack() {
        fightFlowSteps.playerAttack();
        if (fightModel.getFightStatus().isEnd()) {
            resultController.calculateAndShowResult();
        }
    }

}
