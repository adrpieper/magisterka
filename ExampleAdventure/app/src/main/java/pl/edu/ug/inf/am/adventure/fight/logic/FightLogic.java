package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;

import javax.inject.Inject;
import java.util.List;

@PerAdventureStage
public class FightLogic {

    private FightModel fightModel;

    @Inject
    public FightLogic(FightModel fightModel) {
        this.fightModel = fightModel;
    }

    public void setOpponentsToKill(List<MonsterType> opponentsToKill) {
        fightModel.settOpponentsToKill(opponentsToKill);
        fightModel.setActualOpponent(opponentsToKill.get(0));
        fightModel.setFightStatus(FightStatus.FIGHT);
    }

    public void nextMonster() {
        MonsterType nextMonster = fightModel.getNextMonsterToKill();
        fightModel.setActualOpponent(nextMonster);
        fightModel.setFightStatus(FightStatus.FIGHT);
    }

    public void enemyAttack() {
        int playerHp = fightModel.getPlayerHp() - 10;

        if (playerHp == 0) {
            fightModel.setFightStatus(FightStatus.LOST);
        }
    }

    public void playerAttack() {

        int enemyHp = fightModel.getEnemyHp() - 10;

        if (enemyHp == 0) {
            fightModel.moveActualMonsterToKilled();
        }

        fightModel.setEnemyHp(enemyHp);

        if (fightModel.hasMoreMonstersToKill()) {
            fightModel.setFightStatus(FightStatus.ENEMY_KILLED);
        }else {
            fightModel.setFightStatus(FightStatus.WIN);
        }
    }
}
