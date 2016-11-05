package pl.edu.ug.inf.am.player;

import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.state.GameStateManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlayerStateManager {

    private final GameStateManager gameStateManager;

    @Inject
    public PlayerStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public PlayerState getPlayerState(){
        return gameStateManager.getGameState().getPlayerState();
    }
}
