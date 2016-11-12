package pl.edu.ug.inf.am.adventure.logic;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.FightResultDTO;
import pl.edu.ug.inf.am.adventure.state.AdventureStateManager;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class FightLogic {

    private final AdventureStateManager adventureStateManager;

    @Inject
    public FightLogic(AdventureStateManager adventureStateManager) {
        this.adventureStateManager = adventureStateManager;
    }

    public FightResultDTO fight(){

        FightState fightState = adventureStateManager.getState();
        PlayerState playerState = adventureStateManager.getPlayerState();

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
        FightState fightState = adventureStateManager.getState();
        final List<MonsterType> toKill = fightState.getMonstersToKill();
        MonsterType nextMonster = toKill.get(0);
        fightState.setActualMonster(nextMonster);
        fightState.setEnemyHealth(nextMonster.getHp());
        fightState.setResult(FightState.Result.FIGHT);
        return nextMonster;
    }
}
