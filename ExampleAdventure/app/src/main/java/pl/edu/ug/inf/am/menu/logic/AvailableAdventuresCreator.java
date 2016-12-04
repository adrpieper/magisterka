package pl.edu.ug.inf.am.menu.logic;

import pl.aml.Location;
import pl.aml.adventure.definition.Example;
import pl.aml.adventure.factory.AdventureInstance;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;
import pl.edu.ug.inf.am.menu.dagger.PerMenu;

import javax.inject.Inject;

@PerMenu
public class AvailableAdventuresCreator {

    @Inject
    public AvailableAdventuresCreator() {
    }

    public AvailableAdventures create(){
        AvailableAdventures adventures = new AvailableAdventures();
        adventures.add(new AdventureInstance(Location.CASTLE, Example.class, 1));
        return adventures;
    }
}
