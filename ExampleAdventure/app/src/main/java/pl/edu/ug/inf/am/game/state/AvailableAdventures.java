package pl.edu.ug.inf.am.game.state;

import pl.aml.Location;
import pl.aml.adventure.definition.AdventureDefinition;
import pl.aml.adventure.factory.AdventureInstance;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class AvailableAdventures {
    private final Map<Location,List<AdventureInstance>> adventures;

    public AvailableAdventures() {
        this.adventures = new EnumMap(Location.class);
        for (Location location : Location.values()) {
            adventures.put(location,new ArrayList<AdventureInstance>());
        }
    }

    public List<AdventureInstance> getAdventures(Location location) {
        return adventures.get(location);
    }

    public void add(AdventureInstance instance) {
        adventures.get(instance.getLocation()).add(instance);
    }
}
