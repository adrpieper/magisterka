package pl.edu.ug.inf.am;

import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.state.GameStateManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GameStageStateProvider {
    private final GameStateManager gameStateManager;

    @Inject
    public GameStageStateProvider(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public AdventureState getAdventureState(){
        return gameStateManager.getGameState().getStageState();
    }
}
