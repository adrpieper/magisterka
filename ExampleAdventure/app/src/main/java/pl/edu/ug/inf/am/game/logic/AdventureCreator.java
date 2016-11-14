package pl.edu.ug.inf.am.game.logic;

import pl.aml.Adventure;
import pl.aml.Example;
import pl.aml.Location;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class AdventureCreator {

    @Inject
    public AdventureCreator() {

    }

    public Adventure createNew(Location location){
        return new Example().example();
    }


}
