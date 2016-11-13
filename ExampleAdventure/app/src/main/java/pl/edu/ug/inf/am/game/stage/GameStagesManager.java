package pl.edu.ug.inf.am.game.stage;

import pl.aml.Adventure;
import pl.edu.ug.inf.am.common.StagesManager;
import pl.edu.ug.inf.am.game.dagger.GameComponent;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class GameStagesManager extends StagesManager {

    private final GameComponent gameComponent;

    @Inject
    public GameStagesManager(GameComponent gameComponent) {
        this.gameComponent = gameComponent;
    }

    public void startTrip() {
        start(gameComponent.tripComponent().tripStage());
    }

    public void startAdventure(Adventure adventure) {
        start(gameComponent.adventureComponent().adventureStage(), adventure);
    }
}
