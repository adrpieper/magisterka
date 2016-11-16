package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.logic.FightLogic;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;

import javax.inject.Inject;

@PerAdventureStage
public class FightController {

    private final FightModel fightModel;
    private final FightLogic fightLogic;
    private final ResultController resultController;

    @Inject
    public FightController(FightModel fightModel, FightLogic fightLogic, ResultController resultController) {
        this.fightModel = fightModel;
        this.fightLogic = fightLogic;
        this.resultController = resultController;
    }

    public void nextOpponent() {
        fightLogic.nextMonster();
    }

    public void enemyAttack() {
        fightLogic.enemyAttack();
        if (fightModel.getFightStatus().isEnd()) {
            resultController.calculateAndShowResult();
        }
    }

    public void playerAttack() {
        fightLogic.playerAttack();
        if (fightModel.getFightStatus().isEnd()) {
            resultController.calculateAndShowResult();
        }
    }

}
