package pl.edu.ug.inf.am.adventure.fight.controller;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.fight.logic.FightResultDTO;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventureStage;
import pl.edu.ug.inf.am.adventure.fight.logic.FightLogic;
import pl.edu.ug.inf.am.adventure.fight.model.EnemyModel;
import pl.edu.ug.inf.am.adventure.fight.model.FightModel;
import pl.edu.ug.inf.am.adventure.fight.state.FightState;
import pl.edu.ug.inf.am.player.model.PlayerModel;
import pl.edu.ug.inf.am.player.state.PlayerState;

import javax.inject.Inject;

@PerAdventureStage
public class FightController {

    private final FightState fightState;
    private final PlayerState playerState;
    private final FightNavigator fightNavigator;
    private final FightLogic fightLogic;

    @Inject
    public FightController(FightState fightState, PlayerState playerState, FightNavigator fightNavigator, FightLogic fightLogic) {
        this.fightState = fightState;
        this.playerState = playerState;
        this.fightNavigator = fightNavigator;
        this.fightLogic = fightLogic;
    }


    public FightModel createFightModel() {
        return new FightModel(
            new EnemyModel(fightState.getActualMonster(), fightState.getEnemyHealth()),
            new PlayerModel(playerState),
            fightState.getResult()
        );
    }

    public void nextEnemy(FightModel fightModel) {

        final MonsterType monsterType = fightLogic.nextEnemy();
        fightModel.setEnemy(new EnemyModel(monsterType));
        fightModel.setResult(FightState.Result.FIGHT);
    }

    public void fight(FightModel fightModel) {

        final FightResultDTO result = fightLogic.fight();

        if (result.result.isEnd()) {
            fightNavigator.showWin();
        }else {
            fightModel.getEnemy().hp.set(result.enemyHp);
            fightModel.getPlayer().hp.set(result.playerHp);
            fightModel.setResult(result.result);
        }
    }

}
