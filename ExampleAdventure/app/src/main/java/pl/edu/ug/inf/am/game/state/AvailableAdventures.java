package pl.edu.ug.inf.am.game.state;

import pl.aml.impl.location.Place;
import pl.aml.adventure.AdventureInstance;

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

    private AdventureInstance findAndRemove(AdventureInstance instance) {
        for (AdventureInstance existingInstance : getAdventures(instance.getPlace())) {
            if (existingInstance.getDefinition() == instance.getDefinition()) {
                getAdventures(instance.getPlace()).remove(existingInstance);
                return existingInstance;
            }
        }
        return null;
    }

    public void add(AdventureInstance instance) {
        AdventureInstance existingInstance = findAndRemove(instance);
        if (existingInstance != null) {
            AdventureInstance newInstance = new AdventureInstance(
                    instance.getPlace(),
                    instance.getDefinition(),
                    instance.getFrequency() + existingInstance.getFrequency()
            );
            adventures.get(instance.getPlace()).add(newInstance);
        }else {
            adventures.get(instance.getPlace()).add(instance);
        }

    }

    public void remove(AdventureInstance instance) {
        AdventureInstance existingInstance = findAndRemove(instance);
        if (existingInstance != null) {
            int newFrequency = existingInstance.getFrequency() - instance.getFrequency();
            if (newFrequency > 0) {
                AdventureInstance newInstance = new AdventureInstance(
                        instance.getPlace(),
                        instance.getDefinition(),
                        newFrequency
                );
                adventures.get(instance.getPlace()).add(newInstance);
            }
        }
    }


}
