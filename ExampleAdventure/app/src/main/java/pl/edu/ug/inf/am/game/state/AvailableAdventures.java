package pl.edu.ug.inf.am.game.state;

import pl.aml.location.Place;
import pl.aml.adventure.factory.AdventureInstance;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class AvailableAdventures {
    private final Map<Place,List<AdventureInstance>> adventures;

    public AvailableAdventures() {
        this.adventures = new EnumMap(Place.class);
        for (Place place : Place.values()) {
            adventures.put(place,new ArrayList<AdventureInstance>());
        }
    }

    public List<AdventureInstance> getAdventures(Place place) {
        return adventures.get(place);
    }

    public void add(AdventureInstance instance) {
        adventures.get(instance.getPlace()).add(instance);
    }
}
