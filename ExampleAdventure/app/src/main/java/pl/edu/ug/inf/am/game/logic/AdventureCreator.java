package pl.edu.ug.inf.am.game.logic;

import pl.aml.adventure.Adventure;
import pl.aml.adventure.AdventureBuilder;
import pl.aml.adventure.definition.AdventureDefinition;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class AdventureCreator {

    @Inject
    public AdventureCreator() {
    }

    public Adventure create(Class<? extends AdventureDefinition> definition) {

        try {
            AdventureBuilder adventure = new AdventureBuilder();
            definition.newInstance().define(adventure);
            return adventure.build();
        } catch (InstantiationException e) {
            throw  new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
