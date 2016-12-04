package pl.aml.adventure.definition;

import pl.aml.adventure.AStage;

import static pl.aml.MonsterType.DRAGON;
import static pl.aml.adventure.AmlInternalDSL.aFightWith;

public class ExampleDragon implements AdventureDefinition{

    @Override
    public AStage define() {
        return aFightWith(DRAGON);
    }
}
