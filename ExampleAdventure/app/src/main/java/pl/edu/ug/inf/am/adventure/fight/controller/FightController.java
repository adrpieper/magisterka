package pl.edu.ug.inf.am.adventure.fight.controller;

import android.os.Handler;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.logic.FightBasicSteps;
import pl.edu.ug.inf.am.adventure.fight.logic.FightOpponentsManager;
import pl.edu.ug.inf.am.adventure.fight.logic.SkillsLogic;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;
import pl.edu.ug.inf.am.adventure.fight.model.SkillModel;

import javax.inject.Inject;

@PerAdventureStage
public class FightController {

    private final FightModel fightModel;
    private final FightOpponentsManager opponentsManager;
    private final FightBasicSteps fightBasicSteps;
    private final ResultController resultController;
    private final SkillsLogic skillsLogic;
    private final Handler handler;
    @Inject
    public FightController(FightModel fightModel, FightOpponentsManager opponentsManager, FightBasicSteps fightBasicSteps, ResultController resultController, SkillsLogic skillsLogic) {
        this.fightModel = fightModel;
        this.opponentsManager = opponentsManager;
        this.fightBasicSteps = fightBasicSteps;
        this.resultController = resultController;
        this.skillsLogic = skillsLogic;
        this.handler = new Handler();
    }

    public void nextOpponent() {
        opponentsManager.nextMonster();
        skillsLogic.degreaseCooldowns();
    }

    public void enemyAttack() {
        fightBasicSteps.enemyAttack();
        endEnemyTurn();
    }

    public void playerAttack() {
        fightBasicSteps.playerBasicAttack();
        endPlayerTurn();
    }

    public void useSkill(SkillModel skill) {
        skillsLogic.playerUse(skill);
        endPlayerTurn();
    }

    private void endEnemyTurn() {
        if (fightModel.getFightStatus() == FightStatus.LOST) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    resultController.calculateAndShowResult();
                }
            }, 1000);
        }
    }
    private void endPlayerTurn() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkResult();
            }
        }, 1000);
    }

    private void checkResult() {
        if (fightModel.getFightStatus() == FightStatus.ENEMY_KILLED) {
            nextOpponent();
        }else if (fightModel.getFightStatus() == FightStatus.ENEMY_TURN) {
            enemyAttack();
        }else if (fightModel.getFightStatus() == FightStatus.WIN) {
            resultController.calculateAndShowResult();
        }
    }
}
