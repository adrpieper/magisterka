package pl.aml.impl.adventure;

import pl.aml.adventure.AContext;
import pl.aml.adventure.APredicate;
import pl.aml.adventure.AStage;
import pl.aml.adventure.AdventureDefinition;

import static pl.aml.adventure.AmlInternalDSL.*;
import static pl.aml.impl.opponent.OpponentType.DRAGON;

public class ExampleDragon implements AdventureDefinition {

    @Override
    public AStage define() {
        return aFightWith().build();
    }
}
