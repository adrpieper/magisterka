package pl.edu.ug.inf.am.game.logic;

import pl.aml.adventure.Adventure;
import pl.aml.adventure.AdventureDefinition;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

import static pl.adrian.util.Reflection.*;

@PerGame
public class AdventureCreator {

    @Inject
    public AdventureCreator() {
    }

    public Adventure create(Class<? extends AdventureDefinition> definition) {

        return new Adventure(newInstance(definition).define());

    }


}
