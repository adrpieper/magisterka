package pl.edu.ug.inf.am.game.logic;

import pl.edu.ug.inf.am.game.player.PlayerStatsUpdater;
import pl.edu.ug.inf.am.game.state.GameState;
import pl.edu.ug.inf.am.game.dagger.GameSubComponentManager;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class GameInitializer {

    private final GameState gameState;
    private final GameSubComponentManager gameSubComponentManager;
    private final PlayerStatsUpdater statsUpdater;

    @Inject
    public GameInitializer(GameState gameState, GameSubComponentManager gameSubComponentManager, PlayerStatsUpdater statsUpdater) {
        this.gameState = gameState;
        this.gameSubComponentManager = gameSubComponentManager;
        this.statsUpdater = statsUpdater;
    }

    public void init() {
        if (gameState.getState() != GameState.State.RUNNING) {
            gameSubComponentManager.startTrip();
            statsUpdater.updateBasicStats();
            statsUpdater.updateBonusStats();
            gameState.setState(GameState.State.RUNNING);
        }
    }
}
