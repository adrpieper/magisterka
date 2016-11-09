package pl.edu.ug.inf.am.trip;

import pl.aml.AStageInitializer;
import pl.aml.Location;
import pl.edu.ug.inf.am.adventure.AdventureCreator;
import pl.edu.ug.inf.am.adventure.state.AdventureState;
import pl.edu.ug.inf.am.stage.GameStage;
import pl.edu.ug.inf.am.stage.StageManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocationManager {

    private final StageManager stageManager;
    private final AdventureCreator adventureCreator;
    private final AStageInitializer initializer;

    @Inject
    public LocationManager(StageManager stageManager, AdventureCreator adventureCreator, AStageInitializer initializer) {
        this.stageManager = stageManager;
        this.adventureCreator = adventureCreator;
        this.initializer = initializer;
    }

    public void enterInto(Location location) {

        final AdventureState adventureState = adventureCreator.createNew(location);
        adventureState.getAStage().init(initializer);
        stageManager.changeStage(GameStage.ADVENTURE, adventureState);

    }
}
