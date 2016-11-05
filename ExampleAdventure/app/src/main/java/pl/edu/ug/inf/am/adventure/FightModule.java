package pl.edu.ug.inf.am.adventure;

import pl.aml.Monster;
import pl.edu.ug.inf.am.adventure.model.EnemyModel;
import pl.edu.ug.inf.am.adventure.model.FightModel;
import pl.edu.ug.inf.am.adventure.model.ResultModel;
import pl.edu.ug.inf.am.player.model.PlayerModel;
import pl.edu.ug.inf.am.state.GameState;
import pl.edu.ug.inf.am.state.GameStateManager;
import pl.edu.ug.inf.am.view.ViewManage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FightModule {

    private final GameStateManager gameStateManager;
    private final ViewManage viewManage;

    @Inject
    public FightModule(GameStateManager gameStateManager, ViewManage viewManage) {
        this.gameStateManager = gameStateManager;
        this.viewManage = viewManage;
    }

    public FightModel createFightModel() {
        GameState gameState = gameStateManager.getGameState();
        AdventureState adventureState = gameState.getStageState();
        return new FightModel(new EnemyModel(Monster.ORC), new PlayerModel(gameState.getPlayerState()));
    }

    public void fight(FightModel fightModel) {
        final EnemyModel enemy = fightModel.getEnemyModel();
        final PlayerModel player = fightModel.getPlayerModel();

        int playerAttack = 10;
        int enemyAttack = 15;
        int enemyNewHealth = Math.max(0,enemy.health.get() - playerAttack);
        int playerNewHealth = Math.max(0,player.hp.get() - enemyAttack);

        AdventureState state = gameStateManager.getGameState().getStageState();
        if (enemyNewHealth == 0 || playerNewHealth == 0){
            state.setIsEnd(true);
            viewManage.show(gameStateManager.getGameState());
        }else {
            enemy.health.set(enemyNewHealth);
            player.hp.set(playerNewHealth);
            state.setEnemyHealth(enemyNewHealth);
            gameStateManager.getGameState().getPlayerState().setHealt(playerNewHealth);
        }

    }

}
