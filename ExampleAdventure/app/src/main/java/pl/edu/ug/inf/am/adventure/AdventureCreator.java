package pl.edu.ug.inf.am.adventure;

import pl.aml.Adventure;
import pl.aml.AdventuresFactory;
import pl.aml.Location;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AdventureCreator {

    @Inject
    public AdventureCreator() {

    }

    public AdventureState createNew(Location location){

        final List<Adventure> adventures = new AdventuresFactory().createAdventures();

        for (Adventure adventure : adventures) {
            if (adventure.getLocation().equals(location))
                return createWith(adventure);
        }

        return null;
    }

    private AdventureState createWith(Adventure adventure){
        return new AdventureState(adventure.getLocation());
    }

}

