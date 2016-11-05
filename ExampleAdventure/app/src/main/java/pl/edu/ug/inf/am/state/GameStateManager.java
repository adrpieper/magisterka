package pl.edu.ug.inf.am.state;

import pl.edu.ug.inf.am.state.GameState;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class GameStateManager {

    @Inject
    GameStateManager() {

    }

    private GameState gameState = new GameState();

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
