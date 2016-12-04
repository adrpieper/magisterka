package pl.edu.ug.inf.am.menu.logic;

import pl.aml.Location;
import pl.aml.adventure.definition.ExampleDragon;
import pl.aml.adventure.definition.ExampleTroll;
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
        adventures.add(new AdventureInstance(Location.CASTLE, ExampleTroll.class, 1));
        adventures.add(new AdventureInstance(Location.FORREST, ExampleTroll.class, 1));
        adventures.add(new AdventureInstance(Location.FORREST, ExampleDragon.class, 6));
        return adventures;
    }
}
