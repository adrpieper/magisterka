package pl.edu.ug.inf.am.adventure.state;

import pl.aml.AStage;
import pl.edu.ug.inf.am.GameStageStateProvider;
import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.state.GameStateManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.Stack;

@Singleton
public class AdventureStateManager {

    private final GameStateManager stateManager;
    private final GameStageStateProvider gameStageStateProvider;

    @Inject
    public AdventureStateManager(GameStateManager stateManager, GameStageStateProvider gameStageStateProvider) {
        this.stateManager = stateManager;
        this.gameStageStateProvider = gameStageStateProvider;
    }

    public <T extends AStageState> T getState() {
        return gameStageStateProvider.getAdventureState().getState();
    }

    public PlayerState getPlayerState() {
        return stateManager.getGameState().getPlayerState();
    }

    public void addStages(Collection<AStage> stages) {
        gameStageStateProvider.getAdventureState().addStages(stages);
    }

    public Stack<AStage> getStagesStack() {
        return gameStageStateProvider.getAdventureState().getStagesStack();
    }

    public void setState(AStageState state) {
        gameStageStateProvider.getAdventureState().setState(state);
    }
}
