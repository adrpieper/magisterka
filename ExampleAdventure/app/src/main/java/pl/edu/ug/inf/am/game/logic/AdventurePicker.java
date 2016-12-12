package pl.edu.ug.inf.am.game.logic;

import pl.aml.adventure.Adventure;
import pl.aml.location.Place;
import pl.aml.adventure.End;
import pl.aml.adventure.factory.AdventureInstance;
import pl.edu.ug.inf.am.common.ObjectRandom;
import pl.edu.ug.inf.am.game.dagger.PerGame;
import pl.edu.ug.inf.am.game.state.AvailableAdventures;

import javax.inject.Inject;
import java.util.List;

@PerGame
public class AdventurePicker {

    private final AvailableAdventures availableAdventures;
    private final ObjectRandom objectRandom;
    private final AdventureCreator adventureCreator;
    
    @Inject
    public AdventurePicker(AvailableAdventures availableAdventures, ObjectRandom objectRandom, AdventureCreator adventureCreator) {

        this.availableAdventures = availableAdventures;
        this.objectRandom = objectRandom;
        this.adventureCreator = adventureCreator;
    }

    public Adventure pick(Place place) {
        List<AdventureInstance> adventures = availableAdventures.getAdventures(place);

        if (adventures.isEmpty()) {
            return new Adventure(End.instance());
        }

        AdventureInstance adventure = objectRandom.rand(adventures, new ObjectRandom.FrequencyGetter<AdventureInstance>() {
            @Override
            public int get(AdventureInstance object) {
                return object.getFrequency();
            }
        });

        return adventureCreator.create(adventure.getDefinition());
    }
}

