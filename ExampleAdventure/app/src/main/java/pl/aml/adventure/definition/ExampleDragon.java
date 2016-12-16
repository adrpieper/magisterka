package pl.aml.adventure.definition;

import pl.aml.adventure.AContext;
import pl.aml.adventure.APredicate;
import pl.aml.adventure.AStage;

import static pl.aml.adventure.AmlInternalDSL.*;
import static pl.aml.opponent.OpponentType.DRAGON;

public class ExampleDragon implements AdventureDefinition{

    @Override
    public AStage define() {
        return aFightWith().build();
    }
}
