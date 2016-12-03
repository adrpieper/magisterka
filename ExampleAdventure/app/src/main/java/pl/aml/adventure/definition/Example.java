package pl.aml.adventure.definition;

import pl.aml.adventure.AdventureBuilder;

import static pl.aml.MonsterType.*;
import static pl.aml.adventure.AmlInternalDSL.aFightWith;
import static pl.aml.adventure.AmlInternalDSL.multi;

public class Example implements AdventureDefinition{

    @Override
    public void define(AdventureBuilder adventure) {
        adventure
            .startsFrom(
                    multi(aFightWith(DRAGON), aFightWith(TROLL))
            );
    }
}
