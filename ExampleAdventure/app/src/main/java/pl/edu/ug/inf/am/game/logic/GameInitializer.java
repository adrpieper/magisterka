package pl.edu.ug.inf.am.game.logic;

import pl.edu.ug.inf.am.game.state.GameState;
import pl.edu.ug.inf.am.game.dagger.GameSubComponentManager;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class GameInitializer {

    private final GameState gameState;
    private final GameSubComponentManager gameSubComponentManager;

    @Inject
    public GameInitializer(GameState gameState, GameSubComponentManager gameSubComponentManager) {
        this.gameState = gameState;
        this.gameSubComponentManager = gameSubComponentManager;
    }

    public void init() {
        if (gameState.getState() != GameState.State.RUNNING) {
            gameSubComponentManager.startTrip();
            gameState.setState(GameState.State.RUNNING);
        }
    }
}
