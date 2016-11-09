package pl.edu.ug.inf.am.adventure;

import pl.edu.ug.inf.am.GameStageStateProvider;
import pl.edu.ug.inf.am.adventure.logic.FightLogic;
import pl.edu.ug.inf.am.adventure.model.EnemyModel;
import pl.edu.ug.inf.am.adventure.model.FightModel;
import pl.edu.ug.inf.am.adventure.state.FightState;
import pl.edu.ug.inf.am.player.model.PlayerModel;
import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.state.GameStateManager;
import pl.edu.ug.inf.am.view.MainController;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FightController {

    private final GameStateManager gameStateManager;
    private final GameStageStateProvider stateProvider;
    private final MainController mainController;
    private final FightLogic fightLogic;

    @Inject
    public FightController(GameStateManager gameStateManager, GameStageStateProvider stateProvider, MainController mainController, FightLogic fightLogic) {
        this.gameStateManager = gameStateManager;
        this.stateProvider = stateProvider;
        this.mainController = mainController;
        this.fightLogic = fightLogic;
    }

    public FightModel createFightModel() {
        FightState fightState = stateProvider.getAdventureState().getState();
        return new FightModel(
            new EnemyModel(fightState.getActualMonster(), fightState.getEnemyHealth()),
            new PlayerModel(gameStateManager.getGameState().getPlayerState())
        );
    }

    public void fight(FightModel fightModel) {
        final EnemyModel enemy = fightModel.getEnemyModel();
        final PlayerModel player = fightModel.getPlayerModel();

        FightState state = stateProvider.getAdventureState().getState();
        PlayerState playerState = gameStateManager.getGameState().getPlayerState();
        final FightResultDTO result = fightLogic.fight(state, playerState);

        enemy.health.set(result.enemyHp);
        player.hp.set(result.playerHp);
        state.setEnemyHealth(result.enemyHp);
        playerState.setHealt(result.playerHp);

        if (result.enemyHp == 0 || result.playerHp == 0){
            state.setIsEnd(true);
            mainController.show(gameStateManager.getGameState());
        }
    }

}
