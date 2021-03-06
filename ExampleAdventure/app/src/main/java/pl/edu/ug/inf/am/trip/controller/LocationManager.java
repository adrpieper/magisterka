package pl.edu.ug.inf.am.trip.controller;

import pl.aml.adventure.Adventure;
import pl.aml.impl.location.Place;
import pl.edu.ug.inf.am.game.logic.AdventurePicker;
import pl.edu.ug.inf.am.trip.dagger.PerTrip;
import pl.edu.ug.inf.am.game.dagger.GameSubComponentManager;

import javax.inject.Inject;

@PerTrip
public class LocationManager {

    private final AdventurePicker adventurePicker;
    private final GameSubComponentManager gameStagesManager;

    @Inject
    public LocationManager(AdventurePicker adventurePicker, GameSubComponentManager gameStagesManager) {
        this.adventurePicker = adventurePicker;
        this.gameStagesManager = gameStagesManager;
    }

    public void enterInto(Place place) {
        Adventure adventure = adventurePicker.pick(place);
        gameStagesManager.startAdventure(adventure);
    }
}