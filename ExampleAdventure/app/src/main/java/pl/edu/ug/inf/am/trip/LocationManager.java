package pl.edu.ug.inf.am.trip;

import pl.aml.Location;
import pl.edu.ug.inf.am.adventure.AdventureCreator;
import pl.edu.ug.inf.am.adventure.AdventureState;
import pl.edu.ug.inf.am.stage.GameStage;
import pl.edu.ug.inf.am.stage.StageManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocationManager {

    private final StageManager stageManager;
    private final AdventureCreator adventureCreator;

    @Inject
    public LocationManager(StageManager stageManager, AdventureCreator adventureCreator) {
        this.stageManager = stageManager;
        this.adventureCreator = adventureCreator;
    }

    public void enterInto(Location location) {
        stageManager.changeStage(GameStage.ADVENTURE, adventureCreator.createNew(location));
    }
}
