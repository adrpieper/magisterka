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

    public Adventure createNew(Location location){
        return new Example().example();
    }


}

