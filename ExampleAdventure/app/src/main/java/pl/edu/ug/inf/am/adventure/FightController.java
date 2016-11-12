package pl.edu.ug.inf.am.adventure;

import pl.aml.MonsterType;
import pl.edu.ug.inf.am.adventure.logic.FightLogic;
import pl.edu.ug.inf.am.adventure.model.EnemyModel;
import pl.edu.ug.inf.am.adventure.model.FightModel;
import pl.edu.ug.inf.am.adventure.state.AdventureStateManager;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.player.model.PlayerModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FightController {

    private final AdventureStateManager adventureStateManager;
    private final AStagePresenter aStagePresenter;
    private final FightLogic fightLogic;

    @Inject
    public FightController(AdventureStateManager adventureStateManager, AStagePresenter aStagePresenter, FightLogic fightLogic) {
        this.adventureStateManager = adventureStateManager;
        this.aStagePresenter = aStagePresenter;
        this.fightLogic = fightLogic;
    }

    public FightModel createFightModel() {
        FightState fightState = adventureStateManager.getState();
        return new FightModel(
            new EnemyModel(fightState.getActualMonster(), fightState.getEnemyHealth()),
            new PlayerModel(adventureStateManager.getPlayerState()),
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
            aStagePresenter.showWin();
        }else {
            fightModel.getEnemy().hp.set(result.enemyHp);
            fightModel.getPlayer().hp.set(result.playerHp);
            fightModel.setResult(result.result);
        }
    }

}
