package pl.edu.ug.inf.am.adventure;

import pl.aml.adventure.factory.AdventureInstance;
import pl.edu.ug.inf.am.adventure.dagger.PerAdventure;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;

import javax.inject.Inject;

@PerAdventure
public class AdventuresManager {

    private final AvailableAdventures adventures;

    @Inject
    public AdventuresManager(AvailableAdventures adventures) {
        this.adventures = adventures;
    }

    public void add(AdventureInstance adventureInstance) {
        adventures.add(adventureInstance);
    }

}