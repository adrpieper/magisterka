package pl.edu.ug.inf.am.adventure;

import pl.aml.Adventure;
import pl.aml.Example;
import pl.aml.Location;
import pl.edu.ug.inf.am.adventure.state.AdventureState;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AdventureCreator {

    @Inject
    public AdventureCreator() {

    }

    public AdventureState createNew(Location location){



        return createWith(new Example().example());
    }

    private AdventureState createWith(Adventure adventure){
        AdventureState adventureState = new AdventureState();
        adventureState.setAStage(adventure.getFirstStage());
        return adventureState;
    }

}

