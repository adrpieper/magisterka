package pl.edu.ug.inf.am.adventure.fight.logic;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;
import java.util.List;

@PerAdventureStage
public class FightLogic {

    private FightState fightState;
    private PlayerState playerState;

    @Inject
    public FightLogic(FightState fightState, PlayerState playerState) {
        this.fightState = fightState;
        this.playerState = playerState;
    }

    public FightResultDTO fight(){

        int enemyHp = 0;
        int playerHp = 100;

        if (enemyHp == 0){
            fightState.removeMonsterToKill(fightState.getActualMonster());
            fightState.addKilledMonster(fightState.getActualMonster());

            if (fightState.getMonstersToKill().isEmpty()) {
                fightState.setResult(FightState.Result.WIN);
            }else {
                fightState.setResult(FightState.Result.ENEMY_KILLED);
            }
        }

        fightState.setEnemyHealth(enemyHp);
        playerState.setHealt(playerHp);

        if (playerHp == 0){
            fightState.setResult(FightState.Result.LOST);
        }

        return new FightResultDTO(enemyHp, playerHp, fightState.getResult());
    }

    public MonsterType nextEnemy() {
        fightState.nextMonster();
        return fightState.getActualMonster();
    }
}
