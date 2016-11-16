package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightConsoleModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;

import javax.inject.Inject;
import java.util.List;

@PerAdventureStage
public class FightFlowSteps {

    private FightModel fight;
    private FightConsoleModel console;
    private DamageCalculator damageCalculator;

    @Inject
    public FightFlowSteps(FightModel fight) {
        this.fight = fight;
    }

    public void setOpponentsToKill(List<MonsterType> opponentsToKill) {
        fight.settOpponentsToKill(opponentsToKill);
        fight.setActualOpponent(opponentsToKill.get(0));
        fight.setFightStatus(FightStatus.FIGHT);
    }

    public void nextMonster() {
        MonsterType nextMonster = fight.getNextMonsterToKill();
        fight.setActualOpponent(nextMonster);
        fight.setFightStatus(FightStatus.FIGHT);
    }

    public void enemyAttack() {

        int damage = damageCalculator.calcOpponentDamage(fight.getEnemy());
        int playerHp = fight.getPlayerHp() - damage;

        if (playerHp == 0) {
            fight.setFightStatus(FightStatus.LOST);
        }
        console.setMessage("Player gets " + damage + " damage." );
    }

    public void playerAttack() {

        int damage = damageCalculator.calcPlayerDamage(fight.getPlayer());
        int enemyHp = fight.getEnemyHp() - damage;

        fight.setEnemyHp(enemyHp);

        if (enemyHp == 0) {
            fight.moveActualMonsterToKilled();
            if (fight.hasMoreMonstersToKill()) {
                fight.setFightStatus(FightStatus.ENEMY_KILLED);
            }else {
                fight.setFightStatus(FightStatus.WIN);
            }
        }

        console.setMessage(fight.getEnemy().getMonster().name() + " gets " + damage);
    }
}
