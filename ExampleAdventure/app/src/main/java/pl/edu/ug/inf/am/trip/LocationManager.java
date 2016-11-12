package pl.edu.ug.inf.am.trip;

import pl.aml.Adventure;
import pl.aml.AdventureEngine;
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
    private final AdventureEngine adventureEngine;

    @Inject
    public LocationManager(StageManager stageManager, AdventureCreator adventureCreator, AdventureEngine adventureEngine) {
        this.stageManager = stageManager;
        this.adventureCreator = adventureCreator;
        this.adventureEngine = adventureEngine;
    }

    public void enterInto(Location location) {

        Adventure adventure = adventureCreator.createNew(location);
        adventure.getFirstStage().run(adventureEngine);
        stageManager.changeStage(GameStage.ADVENTURE, new AdventureState());

    }
}
