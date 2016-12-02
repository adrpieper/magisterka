package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.character.FightEngine;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.model.FightConsoleModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightStatus;

import javax.inject.Inject;

@PerAdventureStage
public class FightEngineImpl implements FightEngine {
    private FightModel fight;
    private FightConsoleModel console;

    @Inject
    public FightEngineImpl(FightModel fight, FightConsoleModel console) {
        this.fight = fight;
        this.console = console;
    }

    @Override
    public void takeDamage(int damage) {
        int enemyHp = Math.max(fight.getEnemyHp() - damage,0);

        fight.setEnemyHp(enemyHp);

        if (enemyHp == 0) {
            fight.moveActualMonsterToKilled();
            if (fight.hasMoreMonstersToKill()) {
                fight.setFightStatus(FightStatus.ENEMY_KILLED);
            } else {
                fight.setFightStatus(FightStatus.WIN);
            }
        }else {
            fight.setFightStatus(FightStatus.ENEMY_TURN);
        }

        console.setMessage(fight.getEnemy().getMonster().name() + " gets " + damage);
    }

    @Override
    public void getDamage(int damage) {
        int playerHp = Math.max(fight.getPlayerHp() - damage, 0);
        fight.setPlayerHp(playerHp);
        if (playerHp == 0) {
            fight.setFightStatus(FightStatus.LOST);
            console.setMessage("Player gets " + damage + " damage and dead" );
        }else {
            fight.setFightStatus(FightStatus.PLAYER_TURN);
            console.setMessage("Player gets " + damage + " damage." );
        }
    }
}
