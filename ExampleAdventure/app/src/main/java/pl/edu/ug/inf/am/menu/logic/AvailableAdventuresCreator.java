package pl.edu.ug.inf.am.menu.logic;

import pl.aml.adventure.AdventureInstance;
import pl.aml.impl.start.AdventuresOnStart;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;
import pl.edu.ug.inf.am.menu.dagger.PerMenu;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@PerMenu
public class AvailableAdventuresCreator {

    private final AdventuresOnStart adventuresOnStart;

    @Inject
    public AvailableAdventuresCreator(AdventuresOnStart adventuresOnStart) {

        this.adventuresOnStart = adventuresOnStart;
    }

    public AvailableAdventures create(){
        AvailableAdventures adventures = new AvailableAdventures();
        List<AdventureInstance> instances = new ArrayList<>();
        adventuresOnStart.load(instances);
        for (AdventureInstance instance : instances) {
            adventures.add(instance);
        }
        return adventures;
    }
}
