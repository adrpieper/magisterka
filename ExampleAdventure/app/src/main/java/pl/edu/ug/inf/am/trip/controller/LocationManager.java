package pl.edu.ug.inf.am.trip.controller;

import pl.aml.Adventure;
import pl.aml.Location;
import pl.edu.ug.inf.am.game.logic.AdventureCreator;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.game.stage.GameStagesManager;

import javax.inject.Inject;

@PerTrip
public class LocationManager {

    private final AdventureCreator adventureCreator;
    private final GameStagesManager gameStagesManager;

    @Inject
    public LocationManager(AdventureCreator adventureCreator, GameStagesManager gameStagesManager) {
        this.adventureCreator = adventureCreator;
        this.gameStagesManager = gameStagesManager;
    }


    public void enterInto(Location location) {

        Adventure adventure = adventureCreator.createNew(location);
        gameStagesManager.startAdventure(adventure);


    }
}
